package com.thorny.cryptosphere.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.thorny.cryptosphere.home.domain.model.Crypto
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CryptoListItem(
    crypto: Crypto,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(crypto.id) }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Crypto Icon
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(crypto.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "${crypto.name} logo",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Crypto Info
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = crypto.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = crypto.symbol.uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Price Info
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = formatPrice(crypto.priceInEur),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = formatPercentage(crypto.priceChangePercentage24h),
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (crypto.priceChangePercentage24h >= 0)
                        MaterialTheme.colorScheme.primary
                    else
                        MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

private fun formatPrice(price: Double): String {
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(price)
}

private fun formatPercentage(percentage: Double): String {
    return String.format(Locale.getDefault(),"%.2f%%", percentage)
}