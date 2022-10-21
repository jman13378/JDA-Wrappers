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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import SlashCommand;
import SlashCommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static final HashMap<String, SlashCommand> commands = new HashMap();
    public MainListener() {
    	ArrayList<SlashCommand> botCommands = new ArrayList<>(Arrays.asList(
    			new Chop()));
    	for (SlashCommand command : botCommands) {
    		commands.put(command.getName().toLowerCase(), command);
    	}
    }
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    	SlashCommand command = commands.get(event.getName());
    	command.execute(new SlashCommandEvent(event));
    }
}
