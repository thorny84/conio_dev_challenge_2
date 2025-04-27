package com.thorny.cryptosphere.core.testutils

object TestUtils {
    const val MOCK_BITCOIN_RESPONSE = """
        [
            {
                "id": "bitcoin",
                "symbol": "btc",
                "name": "Bitcoin",
                "current_price": 70187,
                "market_cap": 1381651251183,
                "market_cap_rank": 1,
                "fully_diluted_valuation": 1474000000000,
                "total_volume": 19675962,
                "high_24h": 70187,
                "low_24h": 70187,
                "price_change_24h": 0,
                "price_change_percentage_24h": 0,
                "market_cap_change_24h": 0,
                "market_cap_change_percentage_24h": 0,
                "circulating_supply": 19675962,
                "total_supply": 21000000,
                "max_supply": 21000000,
                "ath": 70187,
                "ath_change_percentage": 0,
                "ath_date": "2024-03-14T00:00:00.000Z",
                "atl": 67.81,
                "atl_change_percentage": 103400,
                "atl_date": "2013-07-06T00:00:00.000Z",
                "roi": null,
                "last_updated": "2024-03-14T00:00:00.000Z"
            }
        ]
    """

    const val MOCK_EMPTY_RESPONSE = "[]"

    const val MOCK_COIN_DETAILS_RESPONSE = """
        {
            "id": "bitcoin",
            "symbol": "btc",
            "name": "Bitcoin",
            "web_slug": "bitcoin",
            "asset_platform_id": null,
            "platforms": {
                "": ""
            },
            "detail_platforms": {
                "": {
                    "decimal_place": null,
                    "contract_address": ""
                }
            },
            "block_time_in_minutes": 10,
            "hashing_algorithm": "SHA-256",
            "categories": [
                "Cryptocurrency",
                "Layer 1 (L1)"
            ],
            "preview_listing": false,
            "public_notice": null,
            "additional_notices": [],
            "localization": {
                "en": "Bitcoin",
                "de": "Bitcoin",
                "es": "Bitcoin",
                "fr": "Bitcoin",
                "it": "Bitcoin",
                "pl": "Bitcoin",
                "ro": "Bitcoin",
                "hu": "Bitcoin",
                "nl": "Bitcoin",
                "pt": "Bitcoin",
                "sv": "Bitcoin",
                "vi": "Bitcoin",
                "tr": "Bitcoin",
                "ru": "Bitcoin",
                "ja": "ビットコイン",
                "zh": "比特币",
                "zh-tw": "比特幣",
                "ko": "비트코인",
                "ar": "بيتكوين",
                "th": "บิตคอยน์",
                "id": "Bitcoin"
            },
            "description": {
                "en": "Bitcoin is a decentralized cryptocurrency originally described in a 2008 whitepaper by a person, or group of people, using the name Satoshi Nakamoto. It was launched soon after, in January 2009."
            },
            "links": {
                "homepage": [
                    "http://www.bitcoin.org"
                ],
                "whitepaper": "https://bitcoin.org/bitcoin.pdf",
                "blockchain_site": [
                    "https://blockchair.com/bitcoin/",
                    "https://btc.com/",
                    "https://btc.tokenview.com/"
                ],
                "official_forum_url": [
                    "https://bitcointalk.org/"
                ],
                "chat_url": [
                    "https://telegram.me/bitcoin"
                ],
                "announcement_url": [
                    "https://bitcointalk.org/index.php?topic=1.0"
                ],
                "twitter_screen_name": "bitcoin",
                "facebook_username": "bitcoins",
                "bitcointalk_thread_identifier": 1,
                "telegram_channel_identifier": "bitcoin",
                "subreddit_url": "https://www.reddit.com/r/bitcoin",
                "repos_url": {
                    "github": [
                        "https://github.com/bitcoin/bitcoin"
                    ],
                    "bitbucket": []
                }
            },
            "image": {
                "thumb": "https://assets.coingecko.com/coins/images/1/thumb/bitcoin.png",
                "small": "https://assets.coingecko.com/coins/images/1/small/bitcoin.png",
                "large": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png"
            },
            "country_origin": "JP",
            "genesis_date": "2009-01-03",
            "sentiment_votes_up_percentage": 100.0,
            "sentiment_votes_down_percentage": 0.0,
            "watchlist_portfolio_users": 1000000,
            "market_cap_rank": 1,
            "market_data": {
                "current_price": {
                    "eur": 70187.0
                },
                "total_value_locked": null,
                "mcap_to_tvl_ratio": null,
                "fdv_to_tvl_ratio": null,
                "roi": null,
                "ath": {
                    "eur": 70187.0
                },
                "ath_change_percentage": {
                    "eur": 0.0
                },
                "ath_date": {
                    "eur": "2024-03-14T00:00:00.000Z"
                },
                "atl": {
                    "eur": 67.81
                },
                "atl_change_percentage": {
                    "eur": 103400.0
                },
                "atl_date": {
                    "eur": "2013-07-06T00:00:00.000Z"
                },
                "market_cap": {
                    "eur": 1381651251183.0
                },
                "market_cap_rank": 1,
                "fully_diluted_valuation": {
                    "eur": 1474000000000.0
                },
                "market_cap_fdv_ratio": 0.937,
                "total_volume": {
                    "eur": 19675962.0
                },
                "high_24h": {
                    "eur": 70187.0
                },
                "low_24h": {
                    "eur": 70187.0
                },
                "price_change_24h": 0.0,
                "price_change_percentage_24h": 0.0,
                "price_change_percentage_7d": 0.0,
                "price_change_percentage_14d": 0.0,
                "price_change_percentage_30d": 0.0,
                "price_change_percentage_60d": 0.0,
                "price_change_percentage_200d": 0.0,
                "price_change_percentage_1y": 0.0,
                "market_cap_change_24h": 0.0,
                "market_cap_change_percentage_24h": 0.0,
                "price_change_24h_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_1h_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_24h_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_7d_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_14d_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_30d_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_60d_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_200d_in_currency": {
                    "eur": 0.0
                },
                "price_change_percentage_1y_in_currency": {
                    "eur": 0.0
                },
                "market_cap_change_24h_in_currency": {
                    "eur": 0.0
                },
                "market_cap_change_percentage_24h_in_currency": {
                    "eur": 0.0
                },
                "total_supply": 21000000.0,
                "max_supply": 21000000.0,
                "circulating_supply": 19675962.0,
                "last_updated": "2024-03-14T00:00:00.000Z"
            },
            "community_data": {
                "facebook_likes": null,
                "twitter_followers": 1000000,
                "reddit_average_posts_48h": 1000,
                "reddit_average_comments_48h": 1000,
                "reddit_subscribers": 1000000,
                "reddit_accounts_active_48h": 1000,
                "telegram_channel_user_count": null
            },
            "developer_data": {
                "forks": 1000,
                "stars": 1000,
                "subscribers": 1000,
                "total_issues": 1000,
                "closed_issues": 1000,
                "pull_requests_merged": 1000,
                "pull_request_contributors": 1000,
                "code_additions_deletions_4_weeks": {
                    "additions": 1000,
                    "deletions": 1000
                },
                "commit_count_4_weeks": 1000,
                "last_4_weeks_commit_activity_series": [
                    1000,
                    1000,
                    1000,
                    1000
                ]
            },
            "status_updates": [],
            "last_updated": "2024-03-14T00:00:00.000Z",
            "tickers": [
                {
                    "base": "BTC",
                    "target": "EUR",
                    "market": {
                        "name": "Binance",
                        "identifier": "binance",
                        "has_trading_incentive": false
                    },
                    "last": 70187.0,
                    "volume": 1000.0,
                    "converted_last": {
                        "btc": 1.0,
                        "eth": 20.0,
                        "usd": 70000.0
                    },
                    "converted_volume": {
                        "btc": 1000.0,
                        "eth": 20000.0,
                        "usd": 70000000.0
                    },
                    "trust_score": "green",
                    "bid_ask_spread_percentage": 0.1,
                    "timestamp": "2024-03-14T00:00:00.000Z",
                    "last_traded_at": "2024-03-14T00:00:00.000Z",
                    "last_fetch_at": "2024-03-14T00:00:00.000Z",
                    "is_anomaly": false,
                    "is_stale": false,
                    "trade_url": "https://www.binance.com/en/trade/BTC_EUR",
                    "token_info_url": null,
                    "coin_id": "bitcoin",
                    "target_coin_id": "euro"
                }
            ]
        }
    """

    const val MOCK_MARKET_CHART_RESPONSE = """
        {
            "prices": [
                [1710374400000, 69702.3087473573],
                [1710460800000, 69702.3087473573],
                [1710547200000, 69702.3087473573]
            ],
            "market_caps": [
                [1710374400000, 1370247487960.09],
                [1710460800000, 1370247487960.09],
                [1710547200000, 1370247487960.09]
            ],
            "total_volumes": [
                [1710374400000, 16408802301.8374],
                [1710460800000, 16408802301.8374],
                [1710547200000, 16408802301.8374]
            ]
        }
    """
} 