# Создайте папку для конфигов
mkdir -p ~/.config/hypr

# Создайте минимальный рабочий конфиг
cat > ~/.config/hypr/hyprland.conf << 'EOF'
# ==================== АВТОЗАПУСК ====================
exec-once = dbus-update-activation-environment --systemd WAYLAND_DISPLAY XDG_CURRENT_DESKTOP
exec-once = systemctl --user import-environment WAYLAND_DISPLAY XDG_CURRENT_DESKTOP
exec-once = ~/.config/hypr/autostart.sh

# ==================== МОНИТОР ====================
monitor=,preferred,auto,1

# ==================== ВВОД ====================
input {
    kb_layout = us,ru
    kb_options = grp:alt_shift_toggle
    follow_mouse = 1
    touchpad {
        natural_scroll = yes
    }
}

# ==================== ОБЩИЕ НАСТРОЙКИ ====================
general {
    gaps_in = 5
    gaps_out = 20
    border_size = 2
    col.active_border = rgba(33ccffee) rgba(00ff99ee) 45deg
    col.inactive_border = rgba(595959aa)
    layout = dwindle
}

# ==================== ОКНА И РАБОЧИЕ СТОЛЫ ====================
dwindle {
    pseudotile = yes
    preserve_split = yes
}

master {
    new_is_master = true
}

gestures {
    workspace_swipe = on
}

# ==================== КЛАВИШНЫЕ СОЧЕТАНИЯ ====================
$mainMod = SUPER

# Запуск приложений
bind = $mainMod, RETURN, exec, foot
bind = $mainMod, D, exec, wofi --show drun
bind = $mainMod, E, exec, thunar
bind = $mainMod, W, exec, firefox

# Основные действия
bind = $mainMod, Q, killactive,
bind = $mainMod, M, exit,
bind = $mainMod, F, fullscreen,
bind = $mainMod, V, togglefloating,

# Перемещение между окнами
bind = $mainMod, left, movefocus, l
bind = $mainMod, right, movefocus, r
bind = $mainMod, up, movefocus, u
bind = $mainMod, down, movefocus, d

# Рабочие столы
bind = $mainMod, 1, workspace, 1
bind = $mainMod, 2, workspace, 2
bind = $mainMod, 3, workspace, 3
bind = $mainMod, 4, workspace, 4
bind = $mainMod, 5, workspace, 5
bind = $mainMod, 6, workspace, 6
bind = $mainMod, 7, workspace, 7
bind = $mainMod, 8, workspace, 8
bind = $mainMod, 9, workspace, 9
bind = $mainMod, 0, workspace, 10

# Перемещение окон
bind = $mainMod SHIFT, 1, movetoworkspace, 1
bind = $mainMod SHIFT, 2, movetoworkspace, 2
bind = $mainMod SHIFT, 3, movetoworkspace, 3
bind = $mainMod SHIFT, 4, movetoworkspace, 4
bind = $mainMod SHIFT, 5, movetoworkspace, 5
bind = $mainMod SHIFT, 6, movetoworkspace, 6
bind = $mainMod SHIFT, 7, movetoworkspace, 7
bind = $mainMod SHIFT, 8, movetoworkspace, 8
bind = $mainMod SHIFT, 9, movetoworkspace, 9
bind = $mainMod SHIFT, 0, movetoworkspace, 10

# Мультимедиа клавиши
bind = , XF86AudioRaiseVolume, exec, pamixer -i 5
bind = , XF86AudioLowerVolume, exec, pamixer -d 5
bind = , XF86AudioMute, exec, pamixer -t
bind = , XF86MonBrightnessUp, exec, brightnessctl set +10%
bind = , XF86MonBrightnessDown, exec, brightnessctl set 10%-

# Скриншоты
bind = , PRINT, exec, grim -g "$(slurp)" - | swappy -f -
bind = SHIFT, PRINT, exec, grim - | swappy -f -
EOF