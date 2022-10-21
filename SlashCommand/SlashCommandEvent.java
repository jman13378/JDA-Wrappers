import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.IMentionable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Message.Attachment;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.utils.FileUpload;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;

public class SlashCommandEvent {
	/**
     * the max messages
     */
    @SuppressWarnings("unused")
	private static final int MAX_MESSAGES = 2;
    /**
     * the message received event
     */
    private final SlashCommandInteractionEvent event;

    /**
     * the command event
     *
     * @param event the event
     * @param args the arguments the user sent
     */
    public SlashCommandEvent(SlashCommandInteractionEvent event) {
        this.event = event;
    }
    
    /**
     * gets the arguments
     *
     * @return args, the arguments
     */
    public List<OptionMapping> getArgs() {
        return this.event.getOptions();
    }
    /**
     * gets the {@link SlashCommandInteractionEvent}
     *
     * @return event, the {@link SlashCommandInteractionEvent}
     */
    public SlashCommandInteractionEvent getEvent() {
        return this.event;
    }
    /**
     * Gets an option as a {@link Attachment}
     *
     * @param option the option to get
     * @return Attachment, the {@link Attachment} within the option
     */
    public Attachment getOptionAsAttachment(String option) {
        return this.event.getOption(option).getAsAttachment();
    }
    /**
     * Gets an option as a {@link Boolean}
     *
     * @param option the option to get
     * @return Boolean, the {@link Boolean} within the option
     */
    public Boolean getOptionAsBoolean(String option) {
        return this.event.getOption(option).getAsBoolean();
    }
    /**
     * Gets an option as a {@link Member}
     *
     * @param option the option to get
     * @return Member, the {@link Member} within the option
     */
    public Member getOptionAsMember(String option) {
        return this.event.getOption(option).getAsMember();
    }
    /**
     * Gets an option as a {@link Role}
     *
     * @param option the option to get
     * @return Role, the {@link Role} within the option
     */
    public Role getOptionAsRole(String option) {
        return this.event.getOption(option).getAsRole();
    }
    /**
     * Gets an option as a {@link Mentionable}
     *
     * @param option the option to get
     * @return IMentionable, the {@link IMentionable} within the option
     */
    public IMentionable getOptionAsMentionable(String option) {
        return this.event.getOption(option).getAsMentionable();
    }
    

    /**
     * Gets an option as a {@link Long}
     * 
     * @param option the option to get
     * @return Long, the {@link Long} within the option
     * 
     */
    public Long getOptionAsLong(String option) {
        return this.event.getOption(option).getAsLong();
    }
    /**
     * Gets an option as a {@link User}
     * 
     * @param option the option to get
     * @return User, the {@link User} within the option
     */
    public User getOptionAsUser(String option) {
        return this.event.getOption(option).getAsUser();
    }
    /**
     * Gets an option as a {@link Channel}
     *
     * @param option the option to get
     * @return Channel, the {@link Channel} within the option
     */
    public Channel getOptionAsChannel(String option) {
        return this.event.getOption(option).getAsChannel();
    }
    /**
     * Gets an option as a {@link Double}
     *
     * @param option the option to get
     * @return Double, the {@link Double} within the option
     */
    public Double getOptionAsDouble(String option) {
        return this.event.getOption(option).getAsDouble();
    }

    /**
     * Gets an option as a {@link Integer}
     *
     * @param option the option to get
     * @return Integer, the {@link Integer} within the option
     */
    public Integer getOptionAsInteger(String option) {
        return this.event.getOption(option).getAsInt();
    }
    /**
     * Gets an option as a {@link String}
     *
     * @param option the option to get
     * @return String, the {@link String} within the option
     */
    public String getOptionAsString(String option) {
        return this.event.getOption(option).getAsString();
    }
    /**
     * reply to the message sent
     *
     * @param message the {@link Message}({@link String})  content
     */
    public void reply(String message) {
        this.event.getHook().sendMessage(message).queue();
    }
    /**
     * reply to the message sent
     *
     * @param message the {@link Message}({@link String})  content
     */
    public void reply(String message, Consumer<Message> success, Consumer<Throwable> failure) {
        this.event.getHook().sendMessage(message).queue(success,failure);
    }
    /**
     * reply to the message sent
     *
     * @param message the {@link Message}({@link String})  content
     */
    public void reply(String message, Consumer<Message> success) {
        this.event.getHook().sendMessage(message).queue(success);
    }
    /**
     * reply to the message sent
     *
     * @param embed the {@link MessageEmbed} content
     */
    public void reply(MessageEmbed embed) {
        this.event.getHook().sendMessageEmbeds(embed).queue();
    }
    /**
     * reply to the message sent with an action row
     *
     * @param message the {@link Message} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(String message, List<ItemComponent> item) {
    	
        this.event.getHook().sendMessage(message).addActionRow(item).queue();
    }
    /**
     * reply to the message sent with an embed and a action row
     *
     * @param embeds the {@link Embed} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(MessageEmbed embeds, List<ItemComponent> item) {
    	
        this.event.getHook().sendMessageEmbeds(embeds).addActionRow(item).queue();
    }
    /**
     * reply to the message sent with an action row
     *
     * @param message the {@link Message} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(String message, List<ItemComponent> item, Consumer<Message> success) {
    	
        this.event.getHook().sendMessage(message).addActionRow(item).queue(success);
    }
    /**
     * reply to the message sent with an embed and a action row
     *
     * @param embeds the {@link Embed} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(MessageEmbed embeds, List<ItemComponent> item, Consumer<Message> success) {
    	
        this.event.getHook().sendMessageEmbeds(embeds).addActionRow(item).queue(success);
    }
    /**
     * reply to the message sent with an action row
     *
     * @param message the {@link Message} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(String message, List<ItemComponent> item, Consumer<Message> success, Consumer<Throwable> failure) {
    	
        this.event.getHook().sendMessage(message).addActionRow(item).queue(success,failure);
    }
    /**
     * reply to the message sent with an embed and a action row
     *
     * @param embeds the {@link Embed} content
     * @param item the {@link ItemComponent} for the {@link ActionRow}
     */
    public void reply(MessageEmbed embeds, List<ItemComponent> item, Consumer<Message> success, Consumer<Throwable> failure) {
    	
        this.event.getHook().sendMessageEmbeds(embeds).addActionRow(item).queue(success,failure);
    }
    /**
     * reply to the message sent
     *
     * @param embed the embed content
     * @param success the message
     */
    public void reply(MessageEmbed embed, Consumer<Message> success) {
        this.event.getHook().sendMessageEmbeds(embed).queue(success);
    }
    /**
     * reply to the message sent
     *
     * @param embed the embed content
     * @param success the message
     * @param failure the fail
     */
    public void reply(MessageEmbed embed, Consumer<Message> success, Consumer<Throwable> failure) {
        this.event.getHook().sendMessageEmbeds(embed).queue(success, failure);
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     */
    public void reply(Message message) {
    	MessageCreateData data = MessageCreateData.fromMessage(message);
    	
        this.event.getHook().sendMessage(data).queue();
    }
    /**
     * reply to the message sent
     *
     * @param message the message to send
     * @param success the message
     */
    public void reply(Message message, Consumer<Message> success) {
    	MessageCreateData data = MessageCreateData.fromMessage(message);
        this.event.getHook().sendMessage(data).queue(success);
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
        this.event.getHook().sendMessage(data).queue(success, failure);
    }
    /**
     * reply to the message sent
     *
     * @param file the file to send
     * @param filename the files name
     */
    public void reply(File file, String filename) {
    	
    	this.event.getHook().sendFiles(FileUpload.fromData(file, filename)).queue();
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
		String string = msg = message == null ? null : SlashCommandEvent.splitMessage(message).get(0);
        if (msg == null) {
        	this.event.getHook().sendFiles(FileUpload.fromData(file, filename)).queue();
        } else {
        	this.event.getHook().sendMessage(message).addFiles(FileUpload.fromData(file, filename)).queue();
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
     * @return User, the Author
     */
    public User getAuthor() {
        return this.event.getUser();
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
     * @return Member, the member
     */
    public Member getMember() {
        return this.event.getMember();
    }
    /**
     * gets the member
     *
     * @return String, the member
     */
    public void deferReply() {
        this.event.deferReply().queue();
    }
    /**
     * sets the defer status
     * <ul>
     *     <li>Cannot be deleted by the bot</li>
     *     <li>Cannot contain any files/attachments</li>
     *     <li>Cannot be reacted to</li>
     *     <li>Cannot be retrieved</li>
     * </ul>
     * @param ephemeral whether to send as an ephemeral
     */
    public void deferReply(boolean ephemeral) {
        this.event.deferReply(ephemeral).queue();
    }
    /**
     * gets the member
     *
     * @return String, the member
     */
    public void deferReply(Consumer<InteractionHook> success) {
        this.event.deferReply().queue(success);
    }
    /**
     * sets the defer status
     * <ul>
     *     <li>Cannot be deleted by the bot</li>
     *     <li>Cannot contain any files/attachments</li>
     *     <li>Cannot be reacted to</li>
     *     <li>Cannot be retrieved</li>
     * </ul>
     * @param ephemeral whether to send as an ephemeral
     * @return ReplyCallbackAction, the deferReply
     */
    public void deferReply(boolean ephemeral, Consumer<InteractionHook> success) {
        this.event.deferReply(ephemeral).queue(success);
    }
    /**
     * gets the message
     *
     * @return String, the message
     */
    public String getMessage() {
        return this.event.getCommandString();
    }
    /**
     * gets the text channel
     *
     * @return String, the text channel
     */
    public MessageChannel getChannel() {
        return this.event.getMessageChannel();
    }
	/**
	 * reply
	 *
	 * @param printTable
	 */
	public String getCommandName() {
		return this.event.getName();

	}
	private List<OptionMapping> getMembers() {
			
		return this.event.getOptionsByType(OptionType.USER);

	}
	public List<User> getMentionedsMembers() {
		List<OptionMapping> lel = getMembers();
		List<User> lol = new ArrayList<User>();
		for (int i = 0; i < lel.size(); i++) {
			lol.add(lel.get(i).getAsUser());
		}
		return lol;

	}
}
