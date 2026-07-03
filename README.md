# NoRegenNoHunger

> 🇷🇺 [Русский](#русский) | 🇬🇧 [English](#english)

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
4. Edit `plugins/NoRegenAndHungerPlugin/worlds.yml` as needed
5. Use `/noregenandhungerplugin worlds` to instant changes without restart
6. Use `/noregenandhungerplugin reload` to apply changes without restart

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
| `/noregenandhungerplugin reload` | Reloads the config     | `noregenandhungerplugin.reload` |
| `/noregenandhungerplugin worlds` | Configurate all worlds | `noregenandhungerplugin.worlds` |

### Permissions

| Permission                      | Description                        | Default |
|---------------------------------|------------------------------------|---|
| `noregenandhungerplugin.reload` | Allows reloading the plugin config | OP |
| `noregenandhungerplugin.worlds` | Allows changing world settings     | OP |

---

## Русский

Лёгкий Spigot-плагин, отключающий естественную регенерацию здоровья и/или механику голода на сервере. Каждая функция настраивается отдельно через конфиг.

### Возможности

- **Отключение естественной регенерации** — устанавливает правило игры `naturalRegeneration` в `false` во всех мирах (включая динамически загружаемые)
- **Отключение голода** — постоянно поддерживает максимальный уровень сытости и насыщения у игроков
- **Поддержка всех миров** — настройки автоматически применяются к вновь загружаемым мирам
- **Горячая перезагрузка** — обновление конфига без перезапуска сервера через команду
- **Настраиваемое логирование** — возможность включить или отключить сообщения об изменении правил регенерации

### Требования

- Spigot / Paper **1.16.5+**
- Java 8+

### Установка

1. Скачай `.jar` файл из раздела [Releases](../../releases)
2. Помести его в папку `plugins/` на сервере
3. Запусти или перезапусти сервер
4. Отредактируй `plugins/NoRegenAndHungerPlugin/config.yml` по необходимости
5. Используй `/noregenandhungerplugin reload` для применения изменений без перезапуска

### Конфигурация

`config.yml`:

```yaml
# Логировать изменения правила регенерации в консоль
logging: true

# Отключить голод — игроки всегда будут с полной едой и насыщением
no-food-regen: true

# Отключить естественную регенерацию здоровья во всех мирах
no-natural-regen: true
```

### Команды

| Команда | Описание | Право |
|---|---|---|
| `/noregenandhungerplugin reload` | Перезагружает конфиг | `noregenandhungerplugin.reload` |

### Права

| Право | Описание | По умолчанию |
|---|---|---|
| `noregenandhungerplugin.reload` | Позволяет перезагружать конфиг плагина | OP |
