# Teezee observable behavior evidence

This report is generated from the exact Teezee `app_source/` package inputs in this repository. The extractor is passive: it reads files and printable strings only, makes no network requests, and does not execute APK code.

## Content-source boundary

> The APK contains client code, configuration and resource names, but static inspection does not prove that an endpoint is currently live or that it returns any particular movie, episode, recommendation, like or follow result.

Bundled content includes layouts, icons, animation JSON, JavaScript bridge assets, locale/config JSON and native player/downloader libraries. Network-fetched content is represented only by discovered static URL/host strings and packaged client classes; live catalog content, authenticated data and user state remain runtime-dependent.

## Static URL and host evidence

| Evidence | Occurrences | Notes |
|---|---:|---|
| `https://api-fat1.dlight-app.com/https://api.byte-app.com/https://api.eagllwin.comhttps://api.eagllwin.com/https://api.sunnbird.com/` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://app-oss.byte-app.com/Dhttps://transsion-miniapp-android-cdn.oss-eu-central-1.aliyuncs.com/intent` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/a468a92871d008b8eeea63e591669d14.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/e98c2791d579f1563db33c50c8c97f6a.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/04494deba9472a1cfb195ebde4e6ca74.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://spa.sportslivetoday.com/?from=home_top_tab&utm_source=mb_app_inner` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/12/15/1701709eeeb34cfcbfc0360b72b2f2ae.gif` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/09/22/acd11a61e79d8c2d8139b205bddc0f91.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/09/23/09c65d9f85c8387e7bd010641e2a5041.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2026/03/06/8c161743c831083a4476315e790b0cae.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2026/03/06/f492860e27184d32692e6fd6df2dd3f4.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/fd42e3cfb5f51febec6f0b53f1d9ce61.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/3559cbbc388c3ef330a6ae8531eb79ee.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/9581a2ca2e2e70337bb718ede3e3b38b.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/bb7a0174a71e44ed691fb3aebd217139.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/a2a788f15efd831f6fbb70193aaa3757.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://pbcdn.aoneroom.com/image/2025/03/12/2cc017c14374a5d5ee7505b9ad39aec9.png` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://test-acdn.aoneroom.com/image/2024/04/09/39ceb3464701ab4acf649bea5c4ae055.webp` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://test-acdn.aoneroom.com/image/2024/04/09/4bf43297a86d87b03c12f64f9e1f3a2c.webp` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://test-acdn.aoneroom.com/image/2024/04/09/043c53d69fdba41be0bbd9478cffb723.webp` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://app-oss.byte-app.com/app/apppackage/100000/12.0.1_2ca0b0479157478e80b2041fcbeea2a4.zip` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://app-oss.byte-app.com/platform/register/app/logo/9bdc845d05d7402d99a671de9ef648af.jpg?x-oss-process=image/resize,m_fill,w_200,h_200` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://app-oss.byte-app.com/app/apppackage/1000681057309249536/0.0.12_92ff4ec37f49436c8903390a76dcec8f.zip` | 1 | Static packaged string; not contacted or validated by this report. |
| `https://app-oss.byte-app.com/platform/register/app/logo/42b0d4c52e2142d8b24f5696d2c2e95c.png` | 1 | Static packaged string; not contacted or validated by this report. |

### Hosts parsed from URL literals

- `pbcdn.aoneroom.com` (14 occurrence(s))
- `app-oss.byte-app.com` (5 occurrence(s))
- `test-acdn.aoneroom.com` (3 occurrence(s))
- `api-fat1.dlight-app.com` (1 occurrence(s))
- `spa.sportslivetoday.com` (1 occurrence(s))

## Feature/resource evidence

| Feature token | Matching layout files |
|---|---:|
| `audio` | 11 |
| `download` | 103 |
| `follow` | 4 |
| `home` | 43 |
| `language` | 8 |
| `like` | 11 |
| `movie` | 52 |
| `player` | 24 |
| `profile` | 29 |
| `room` | 63 |
| `search` | 51 |
| `subtitle` | 26 |
| `video` | 105 |

## Configuration and animation assets

| Asset | Top-level JSON keys |
|---|---|
| `app_source/assets/appTab.json` | `badgeVer`, `bottomTabs`, `isUgcEnabled`, `version` |
| `app_source/assets/builddatas.json` | `name`, `report`, `version` |
| `app_source/assets/download_analyzing_anima.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_analyzing_anima_night.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_analyzing_success_anima.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_analyzing_success_anima_night.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_icon_status_anima_home.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_icon_status_anima_home_fit.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/download_icon_status_anima_home_fit_night.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/hisavana_ab_data.json` | (array/scalar or no top-level keys) |
| `app_source/assets/immersion_video_guide_swipe_more.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/loading.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/local_mcc.json` | (array/scalar or no top-level keys) |
| `app_source/assets/post_video_res_playing.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/room_top_tab.json` | `defTabId`, `items`, `version` |
| `app_source/assets/sdk_country_cc_mcc.json` | (array/scalar or no top-level keys) |
| `app_source/assets/skulist.json` | `memberRights`, `skuList` |
| `app_source/assets/sub_def_la.json` | (array/scalar or no top-level keys) |
| `app_source/assets/video_land_double_click_backward.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |
| `app_source/assets/video_land_double_click_forward.json` | `assets`, `ddd`, `fr`, `h`, `ip`, `layers`, `markers`, `nm`, `op`, `v`, `w` |

## Interpretation

- **UI/UX:** layout filenames and resources show families for home, movie/short-TV, player, subtitle/audio, search, rooms/community, profiles and downloads.
- **Media:** the package includes player views, Exo/Media3 resources and native codecs/downloader libraries; playback URLs and authorization are runtime-dependent.
- **Likes/follows/downloads:** matching screens and client code are packaged, but server-side mutation success cannot be established without a real account/session.
- **Languages:** locale/resource variants and language-related client code are packaged; the complete live language catalog may be fetched.
