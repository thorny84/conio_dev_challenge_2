package com.thorny.cryptosphere.core.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.thorny.cryptosphere.core.testutils.TestUtils
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NetworkServiceTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var service: ApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getMarketData returns list of coins when successful`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(TestUtils.MOCK_BITCOIN_RESPONSE)

        mockWebServer.enqueue(mockResponse)

        // When
        val result = service.getMarketData(
            vsCurrency = "eur",
            order = "market_cap_desc",
            perPage = 10,
            sparkline = false
        )

        // Then
        assert(result.isNotEmpty())
        assertEquals("bitcoin", result[0].id)
        assertEquals("btc", result[0].symbol)
        assertEquals("Bitcoin", result[0].name)
        assertEquals(70187.0, result[0].currentPrice)
        assertEquals(1381651251183, result[0].marketCap)
    }

    @Test
    fun `getMarketData returns empty list when response is empty`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(TestUtils.MOCK_EMPTY_RESPONSE)

        mockWebServer.enqueue(mockResponse)

        // When
        val result = service.getMarketData(
            vsCurrency = "eur",
            order = "market_cap_desc",
            perPage = 10,
            sparkline = false
        )

        // Then
        assertTrue(result.isEmpty())
    }

    @Test(expected = Exception::class)
    fun `getMarketData throws exception when server error occurs`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(500)

        mockWebServer.enqueue(mockResponse)

        // When
        service.getMarketData(
            vsCurrency = "eur",
            order = "market_cap_desc",
            perPage = 10,
            sparkline = false
        )
    }

    @Test
    fun `getCoinDetails returns coin details when successful`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(TestUtils.MOCK_COIN_DETAILS_RESPONSE)

        mockWebServer.enqueue(mockResponse)

        // When
        val result = service.getCoinDetails("bitcoin")

        // Then
        assertEquals("bitcoin", result.id)
        assertEquals("btc", result.symbol)
        assertEquals("Bitcoin", result.name)
        assertEquals(70187.0, result.marketData.currentPrice["eur"])
        assertEquals(1381651251183.0, result.marketData.marketCap["eur"])
        assertEquals(19675962.0, result.marketData.circulatingSupply)
        assertEquals(21000000.0, result.marketData.totalSupply)
        assertEquals(21000000.0, result.marketData.maxSupply)
    }

    @Test(expected = Exception::class)
    fun `getCoinDetails throws exception when server error occurs`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(500)

        mockWebServer.enqueue(mockResponse)

        // When
        service.getCoinDetails("bitcoin")
    }

    @Test
    fun `getCoinMarketChart returns market chart data when successful`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(TestUtils.MOCK_MARKET_CHART_RESPONSE)

        mockWebServer.enqueue(mockResponse)

        // When
        val result = service.getCoinMarketChart(
            id = "bitcoin",
            vsCurrency = "eur",
            days = 7
        )

        // Then
        assertEquals(3, result.prices.size)
        assertEquals(3, result.marketCaps.size)
        assertEquals(3, result.totalVolumes.size)
        assertEquals(69702.3087473573, result.prices[0][1])
        assertEquals(1370247487960.09, result.marketCaps[0][1])
        assertEquals(16408802301.8374, result.totalVolumes[0][1])
    }

    @Test(expected = Exception::class)
    fun `getCoinMarketChart throws exception when server error occurs`() = runTest {
        // Given
        val mockResponse = MockResponse()
            .setResponseCode(500)

        mockWebServer.enqueue(mockResponse)

        // When
        service.getCoinMarketChart(
            id = "bitcoin",
            vsCurrency = "eur",
            days = 7
        )
    }
} 