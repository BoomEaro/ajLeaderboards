package us.ajg0702.leaderboards.commands.main.subcommands;

import net.kyori.adventure.text.Component;
import us.ajg0702.commands.CommandSender;
import us.ajg0702.commands.SubCommand;
import us.ajg0702.leaderboards.LeaderboardPlugin;

import java.util.Collections;
import java.util.List;

public class Enable extends SubCommand {

    private final LeaderboardPlugin plugin;

    public Enable(LeaderboardPlugin plugin) {
        super("enable", Collections.emptyList(), "ajleaderboards.enable", "enable the plugin");
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

        plugin.performEnable();
        sender.sendMessage(Component.text("Plugin successfully enabled."));
    }
}
