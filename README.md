# NoRegenAndHungerPlugin

> 🇷🇺 [Русский](#русский) | 🇬🇧 [English](#english)

---

## English

A lightweight Spigot plugin that disables natural health regeneration and/or food mechanics on your server. Each feature can be toggled independently via config.

### Features

- **Disable natural regeneration** — sets the `naturalRegeneration` gamerule to `false` on all worlds (including dynamically loaded ones)
- **Disable hunger** — keeps players at full food level and saturation at all times, preventing any hunger-based actions
- **Per-world support** — automatically applies settings to newly loaded worlds
- **Hot reload** — reload config without restarting the server via a command
- **Configurable logging** — toggle log messages about regen rule changes

### Requirements

- Spigot / Paper **1.16.5+**
- Java 8+

### Installation

1. Download the `.jar` file from [Releases](../../releases)
2. Place it in your server's `plugins/` folder
3. Start or restart the server
4. Edit `plugins/NoRegenAndHungerPlugin/config.yml` as needed
5. Use `/noregenandhungerplugin reload` to apply changes without restart

### Configuration

`config.yml`:

```yaml
# Log regen rule changes to the console
logging: true

# Disable hunger — keeps players at full food and saturation at all times
no-food-regen: true

# Disable natural health regeneration in all worlds
no-natural-regen: true
```

### Commands

| Command | Description | Permission |
|---|---|---|
| `/noregenandhungerplugin reload` | Reloads the config | `noregenandhungerplugin.reload` |

### Permissions

| Permission | Description | Default |
|---|---|---|
| `noregenandhungerplugin.reload` | Allows reloading the plugin config | OP |

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
