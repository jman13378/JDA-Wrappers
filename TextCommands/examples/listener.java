/*
* MIT License
* 
* Copyright (c) 2022 jman13378
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
*/

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
