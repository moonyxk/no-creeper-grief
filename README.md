<div align="center">
  
![No Creeper Grief](https://assets.jodek.dev/title/no_creeper_grief.png)

[![jodeks datapacks discord](https://assets.jodek.dev/badge/discord.png)](https://discord.gg/z2n3qTzQY6)&nbsp;&nbsp;
[![datapacks jodek youtube](https://assets.jodek.dev/badge/youtube.png)](https://www.youtube.com/@jodek)&nbsp;&nbsp;
[![no creeper grief minecraft datapack codeberg issues](https://assets.jodek.dev/badge/codeberg_issues.png)](https://codeberg.org/jodeks-datapacks/no-creeper-giref/issues)&nbsp;&nbsp;
[![jodeks datapacks kofi](https://assets.jodek.dev/badge/kofi.png)](https://ko-fi.com/jodek)

## Creeper no longer destroy blocks

![creeper no block destruction, no creeper grief, creeper grief disabled](https://assets.jodek.dev/gif/no_creeper_grief.gif)

&nbsp;

[![jodek datapack suggestions](https://assets.jodek.dev/badge/new_datapack_suggestion.png)](https://codeberg.org/jodeks-datapacks/.profile/issues/new?template=.forgejo%2fISSUE_TEMPLATE%2fdatapack_request.yaml)

&nbsp;

</div>

## Paper plugin

This project is a Paper plugin for Minecraft 26.3, adapted from the No Creeper
Grief datapack by Jodek. It requires Java 25.

Creeper explosions use the original datapack's radius of `-3`; charged creepers
use `-6`, matching Minecraft's explosion multiplier. This prevents block
destruction while preserving the original negative-radius explosion behavior.
Other explosions, such as TNT, are unaffected.

## Build

With a JDK 25 installed, run:

```powershell
.\gradlew.bat clean build
```

On macOS or Linux, run `sh ./gradlew clean build`. The Gradle Wrapper downloads
the required Gradle version automatically.

## Installation

1. Build the project and copy `build/libs/no-creeper-grief-1.3.0.jar` to the
   Paper server's `plugins` directory.
2. Remove the old No Creeper Grief datapack from the world's `datapacks`
   directory so it does not continue running alongside the plugin.
3. Restart the server. No configuration or commands are required.

The original datapack changes creeper data permanently, so already-modified
creepers retain those values after the datapack is removed.
