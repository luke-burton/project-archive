package me.rabrg.clans.cmd;

import me.rabrg.clans.struct.Permission;

public class CmdLock extends FCommand {

	// TODO: This solution needs refactoring.
	/*
	 * clans.lock: description: use the /c lock [on/off] command to temporarily
	 * lock the data files from being overwritten default: op
	 */

	public CmdLock() {
		super();
		this.aliases.add("lock");

		// this.requiredArgs.add("");
		this.optionalArgs.put("on/off", "flip");

		this.permission = Permission.LOCK.node;
		this.disableOnLock = false;

		senderMustBePlayer = false;
		senderMustBeMember = false;
		senderMustBeModerator = false;
		senderMustBeAdmin = false;
	}

	@Override
	public void perform() {
		p.setLocked(this.argAsBool(0, !p.getLocked()));

		if (p.getLocked()) {
			msg("<i>Clans is now locked");
		} else {
			msg("<i>Clans in now unlocked");
		}
	}

}
