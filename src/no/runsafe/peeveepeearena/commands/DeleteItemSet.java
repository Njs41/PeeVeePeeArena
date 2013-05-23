package no.runsafe.peeveepeearena.commands;

import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.peeveepeearena.repositories.ShopRepository;

import java.util.HashMap;

public class DeleteItemSet extends ExecutableCommand
{
	public DeleteItemSet(ShopRepository shopRepository)
	{
		super("deleteset", "Deletes an item set from the shop", "runsafe.peeveepee.sets.delete", "id");
		this.shopRepository = shopRepository;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters)
	{
		int itemSetID = Integer.parseInt(parameters.get("id"));
		if (!this.shopRepository.deleteItemSet(itemSetID))
			return "&cUnable to find an item set with that ID.";

		return "&2The item set has been deleted.";
	}

	private ShopRepository shopRepository;
}