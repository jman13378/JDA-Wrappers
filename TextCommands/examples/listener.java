import Shop;
public class CommandListener extends ListenerAdapter {
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
	private static final HashMap<String, Command> commands = new HashMap();
  
  public CommandListener() {
		ArrayList<Command> botCommands = new ArrayList<>(Arrays.asList(
      new Shop()
				));
	    for (Command command : botCommands) {
	    	commands.put(command.getName().toLowerCase(), command);
	    }
	}
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
            		event.getChannel().sendMessageEmbeds(l.build()).queue(); Bot.newmessage.add(event.getMember().getIdLong());}
                command.execute(new CommandEvent(event, Arrays.copyOfRange(msgRaw.split("\\s+"), 1, args.length)));
            }
        }
    }
