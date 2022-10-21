import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

public class CommandEvent {
	/**
     * the max messages
     */
    @SuppressWarnings("unused")
	private static final int MAX_MESSAGES = 2;
    /**
     * the message received event
     */
    private final MessageReceivedEvent event;
    /**
     * the arguments
     */
    private String[] args;
    /**
     * the command event
     *
     * @param event the event
     * @param args the arguments the user sent
     */
    public CommandEvent(MessageReceivedEvent event, String[] args) {
        this.event = event;
        this.args = args;
    }
    /**
     * gets the arguments
     *
     * @return args, the arguments
     */
    public String[] getArgs() {
        return this.args;
    }
    /**
     * gets the event
     *
     * @return event, the event
     */
    public MessageReceivedEvent getEvent() {
        return this.event;
    }
    /**
     * gets the mentioned members
     *
     * @return mentionedMembers, the members mentioned
     */
    public List<Member> getMentionedMembers() {
        ArrayList<Member> mentionedMembers = new ArrayList<>(this.event.getMessage().getMentions().getMembers());
        if (this.event.getMessage().getContentRaw().startsWith("<@!" + this.event.getJDA().getSelfUser().getId() + ">")) {
            mentionedMembers.remove(0);
        }
        return mentionedMembers;
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     */
    public void reply(String message) {
        this.sendMessage(this.event.getChannel(), message);
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param success the message
     */
    public void reply(String message, Consumer<Message> success) {
        this.sendMessage(this.event.getChannel(), message, success);
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param success the message
     * @param failure the fail
     */
    public void reply(String message, Consumer<Message> success, Consumer<Throwable> failure) {
        this.sendMessage(this.event.getChannel(), message, success, failure);
    }
    /**
     * reply to the message sent
     *
     * @param embed the embed content
     */
    public void reply(MessageEmbed embed) {
        this.event.getChannel().sendMessageEmbeds(embed).queue();
    }
    /**
     * reply to the message sent
     *
     * @param embed the embed content
     * @param success the message
     */
    public void reply(MessageEmbed embed, Consumer<Message> success) {
        this.event.getChannel().sendMessageEmbeds(embed).queue(success);
    }
    /**
     * reply to the message sent
     *
     * @param embed the embed content
     * @param success the message
     * @param failure the fail
     */
    public void reply(MessageEmbed embed, Consumer<Message> success, Consumer<Throwable> failure) {
        this.event.getChannel().sendMessageEmbeds(embed).queue(success, failure);
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     */
    public void reply(Message message) {
    	MessageCreateData data = MessageCreateData.fromMessage(message);
        this.event.getChannel().sendMessage(data).queue();
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param success the message
     */
    public void reply(Message message, Consumer<Message> success) {
    	MessageCreateData data = MessageCreateData.fromMessage(message);
        this.event.getChannel().sendMessage(data).queue(success);
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param success the message
     * @param failure the fail
     */
    public void reply(Message message, Consumer<Message> success, Consumer<Throwable> failure) {
    	MessageCreateData data = MessageCreateData.fromMessage(message);
        this.event.getChannel().sendMessage(data).queue(success, failure);
    }
    /**
     * reply to the message sent
     *
     * @param file the file to send
     * @param filename the files name
     */
    public void reply(File file, String filename) {
    	
    	this.event.getChannel().sendFiles(FileUpload.fromData(file, filename)).queue();
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param file the file to send
     * @param filename the files name
     */
    public void reply(String message, File file, String filename) {
        String msg;
        @SuppressWarnings("unused")
		String string = msg = message == null ? null : CommandEvent.splitMessage(message).get(0);
        if (msg == null) {
        	this.event.getChannel().sendFiles(FileUpload.fromData(file, filename)).queue();
        } else {
        	this.event.getChannel().sendMessage(message).addFiles(FileUpload.fromData(file, filename)).queue();
        }
    }
    /**
     * sends a message
     *
     * @param chan the channel to send
     * @param message the message to send
     */
    private void sendMessage(MessageChannel chan, String message) {
        ArrayList<String> messages = CommandEvent.splitMessage(message);
        for (int i = 0; i < 2 && i < messages.size(); ++i) {
            chan.sendMessage(messages.get(i)).queue();
        }
    }
    /**
     * sends a message
     *
     * @param chan the channel to send
     * @param message the message to send
     */
    private void sendMessage(MessageChannel chan, String message, Consumer<Message> success) {
        ArrayList<String> messages = CommandEvent.splitMessage(message);
        for (int i = 0; i < 2 && i < messages.size(); ++i) {
            if (i + 1 == 2 || i + 1 == messages.size()) {
                chan.sendMessage(messages.get(i)).queue(success);
                continue;
            }
            chan.sendMessage(messages.get(i)).queue();
        }
    }
    /**
     * sends a message
     *
     * @param chan the channel to send
     * @param message the message to send
     * @param success the message
     */
    private void sendMessage(MessageChannel chan, String message, Consumer<Message> success, Consumer<Throwable> failure) {
        ArrayList<String> messages = CommandEvent.splitMessage(message);
        for (int i = 0; i < 2 && i < messages.size(); ++i) {
            if (i + 1 == 2 || i + 1 == messages.size()) {
                chan.sendMessage(messages.get(i)).queue(success, failure);
                continue;
            }
            chan.sendMessage(messages.get(i)).queue();
        }
    }
    /**
     * splits a message
     *
     * @param stringtoSend the sting to send
     *
     * @return msgs, messages
     */
    private static ArrayList<String> splitMessage(String stringtoSend) {
        ArrayList<String> msgs = new ArrayList<>();
        if (stringtoSend != null) {
            stringtoSend = stringtoSend.replace("@everyone", "@everyone").replace("@here", "@here").trim();
            while (stringtoSend.length() > 2000) {
                String temp;
                int leeway = 2000 - stringtoSend.length() % 2000;
                int index = stringtoSend.lastIndexOf("\n", 2000);
                if (index < leeway) {
                    index = stringtoSend.lastIndexOf(" ", 2000);
                }
                if (index < leeway) {
                    index = 2000;
                }
                if (!(temp = stringtoSend.substring(0, index).trim()).equals("")) {
                    msgs.add(temp);
                }
                stringtoSend = stringtoSend.substring(index).trim();
            }
            if (!stringtoSend.equals("")) {
                msgs.add(stringtoSend);
            }
        }
        return msgs;
    }
    /**
     * gets the self user
     *
     * @return String, the self user
     */
    SelfUser getSelfUser() {
        return this.event.getJDA().getSelfUser();
    }
    /**
     * gets the author
     *
     * @return String, the Author
     */
    public User getAuthor() {
        return this.event.getAuthor();
    }
    /**
     * gets the guild
     *
     * @return String, the guild
     */
    public Guild getGuild() {
        return this.event.getGuild();
    }
    /**
     * gets JDA
     *
     * @return String, JDA
     */
    public JDA getJDA() {
        return this.event.getJDA();
    }
    /**
     * gets the member
     *
     * @return String, the member
     */
    public Member getMember() {
        return this.event.getMember();
    }
    /**
     * gets the message
     *
     * @return String, the message
     */
    public Message getMessage() {
        return this.event.getMessage();
    }
    /**
     * gets the text channel
     *
     * @return String, the text channel
     */
    public TextChannel getTextChannel() {
        return this.event.getChannel().asTextChannel();
    }

	/**
	 * @param printTable
	 */
}
