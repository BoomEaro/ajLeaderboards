package us.ajg0702.leaderboards.commands.main.subcommands;

import net.kyori.adventure.text.Component;
import us.ajg0702.commands.CommandSender;
import us.ajg0702.commands.SubCommand;
import us.ajg0702.leaderboards.LeaderboardPlugin;

import java.util.Collections;
import java.util.List;

public class Disable extends SubCommand {

    private final LeaderboardPlugin plugin;

    public Disable(LeaderboardPlugin plugin) {
        super("disable", Collections.emptyList(), "ajleaderboards.disable", "disable the plugin");
        this.plugin = plugin;
    }

    @Override
    public List<String> autoComplete(CommandSender commandSender, String[] strings) {
        return Collections.emptyList();
    }

    @Override
    public void execute(CommandSender sender, String[] args, String label) {
        if (!checkPermission(sender)) {
            sender.sendMessage(plugin.getMessages().getComponent("noperm"));
            return;
        }

        plugin.performDisable();
        sender.sendMessage(Component.text("Plugin successfully disabled."));
    }
}
