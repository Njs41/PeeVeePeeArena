package no.runsafe.peeveepeearena;

import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.command.Command;
import no.runsafe.mailbox.MailHandler;
import no.runsafe.peeveepeearena.commands.GetRating;
import no.runsafe.peeveepeearena.commands.Teleport;
import no.runsafe.peeveepeearena.events.PlayerDeath;
import no.runsafe.peeveepeearena.events.PlayerDropItems;
import no.runsafe.peeveepeearena.events.RightClickBlock;
import no.runsafe.peeveepeearena.events.SignChange;
import no.runsafe.peeveepeearena.pvpporter.TeleportEngine;
import no.runsafe.peeveepeearena.repositories.PlayerRatingRepository;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		this.addComponent(Instances.get("RunsafeMailbox").getComponent(MailHandler.class));
		this.addComponent(PvPArenaEngine.class);
		this.addComponent(RatingHandler.class);

		// Repositories
		this.addComponent(PlayerRatingRepository.class);

		// Teleport
		this.addComponent(TeleportEngine.class);

		// Commands
		Command pvp = new Command("pvp", "PvP related commands", null);
		pvp.addSubCommand(getInstance(Teleport.class));
		pvp.addSubCommand(getInstance(GetRating.class));
		this.addComponent(pvp);

		// Events
		this.addComponent(SignChange.class);
		this.addComponent(RightClickBlock.class);
		this.addComponent(PlayerDeath.class);
		this.addComponent(PlayerDropItems.class);
	}
}
