# NoRegenNoHunger
---

## English

A lightweight Spigot plugin that disables natural health regeneration and/or food mechanics on your server. Each feature can be toggled independently via config.

### Features

- **Disable natural regeneration** — sets the `naturalRegeneration` gamerule to `false` on all worlds (including dynamically loaded ones)
- **Disable hunger** — keeps players at full food level at all times, preventing any hunger-based actions
- **Per-world support** — automatically applies settings to newly loaded worlds
- **Hot reload** — reload config without restarting the server via a command

### Requirements

- Spigot / Paper **1.16.5+**
- Java 8+

### Installation

1. Download the `.jar` file from [Releases](../../releases)
2. Place it in your server's `plugins/` folder
3. Start or restart the server
4. Edit `plugins/noregennohunger/worlds.yml` as needed
5. Use `/noregennohunger worlds` to instant changes without restart
6. Use `/noregennohunger reload` to apply changes without restart

### Configuration

`worlds.yml`:

```yaml
worlds:
  # World Name
  world:
    # Regeneration in this world
    regen-enabled: false
    # Hunger in this world
    hunger-enabled: false
  world_the_end:
    regen-enabled: false
    hunger-enabled: false
  world_nether:
    regen-enabled: false
    hunger-enabled: false
```

### Commands

| Command                          | Description            | Permission                      |
|----------------------------------|------------------------|---------------------------------|
| `/noregennohunger reload` | Reloads the config     | `noregennohunger.reload` |
| `/noregennohunger worlds` | Configurate all worlds | `noregennohunger.worlds` |

### Permissions

| Permission                      | Description                        | Default |
|---------------------------------|------------------------------------|---|
| `noregennohunger.reload` | Allows reloading the plugin config | OP |
| `noregennohunger.worlds` | Allows changing world settings     | OP |

---
