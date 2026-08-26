# Teezee navigation and feature contract

This contract is derived from the exact bundled `app_source/assets/appTab.json` and `app_source/assets/room_top_tab.json`, together with the tracked layout/source names. It describes packaged behavior; it does not invent server responses.

## Bottom navigation

The bundled app-tab configuration declares five primary destinations:

| Destination | Type | Observable behavior | Content source boundary |
|---|---|---|---|
| Home | `BT_HOME` | Opens Home and exposes configured sub-tabs such as Trending, Movie, TV, Anime, ShortTV, Live, Kids, Education, Football, Music, Western, Asian, Nollywood and Game. | Tab configuration and some icons are packaged/static; catalog cards and live content are network-dependent. |
| NovelHub | `BT_NOVEL` | Opens a configured `oneroom://` mini-app route and displays a `HOT` badge. | The deep link targets a separate mini-app route; no live request was made. |
| Fight Zone | `BT_OPERATE` | Opens the configured operation tab with large selected/default icon variants. | Tab metadata/icons are packaged or referenced; destination content is runtime-dependent. |
| Downloads | `BT_DOWNLOADS` | Opens downloaded/downloading media and download-management UI families. | Local download state is device-dependent; resource resolution and permissions are runtime-dependent. |
| Me | `BT_ME` | Opens account/profile/settings-related UI. | User identity, likes, follows, history and account state require an authenticated runtime session. |

The configuration records `isUgcEnabled: false` in the inspected asset version. The package nevertheless contains community/room and UGC-related layouts and classes, so availability may be controlled by remote configuration, account state or another build/runtime flag.

## Room/community navigation

The bundled room configuration declares `Explore` as the default top tab, followed by `Images` and `Nearby`. All three entries use `type: post` and have empty static URLs, indicating that their content is resolved by the application’s room/community client rather than by a literal URL in this asset.

## Observable feature families

The resource and source mirror contains named families for movie and short-TV discovery, search and ranking, profile and subscriptions, room/community posts, video/music playback, subtitle selection and synchronization, download analysis and management, transfer, and local media. Representative layout names include `fragment_home.xml`, `fragment_movie.xml`, `fragment_short_tv_home.xml`, `fragment_video_detail.xml`, `fragment_audio_select_list.xml`, `fragment_subtitle_options.xml`, `fragment_download_main.xml`, `fragment_likes_detail.xml`, `fragment_subscription_list.xml`, `fragment_room_home.xml` and `fragment_search_result.xml`.

The corresponding runtime capabilities are preserved as packaged code/resources: media playback and subtitle components, audio-track selectors, download managers and notification layouts, social/profile screens, and language/locale helpers. Static inspection cannot prove that a server mutation succeeds, that a particular media URL is available, or that a user’s account has access to a premium resource.

## Branding and icons

The original launcher icon variants remain under the `app_source/res/mipmap-*` resource directories. Bottom-tab icon URLs and selected/default icon metadata remain in `appTab.json`; these are static references captured from the package and are not downloaded by this documentation step. The package name remains `com.teezee.app` and no repository/project rename was introduced.
