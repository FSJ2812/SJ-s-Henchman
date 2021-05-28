import java.awt.Color;
import java.util.Random;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class Main {

    public static String prefix = "$", url = "";
    private static final String TOken = System.getenv("TOKEN");
    public static void main(String[] args) {
        DiscordApi Bot = new DiscordApiBuilder().setToken(TOken).login().join();


        Bot.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase(prefix+"q")){ 
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("QUOTES TO MAKE YOUR DAY!!");
                embed.setColor(Color.GREEN);
                embed.setThumbnail("https://i.ibb.co/FX0SMgf/image-2021-05-20-075409.png");
                quote();
                embed.setImage(url);
                embed.setFooter("Have a Nice Day!", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/facebook/65/grinning-face-with-smiling-eyes_1f601.png");
                event.getChannel().sendMessage(embed);
            }
            
            if (event.getMessageContent().substring(0, 4).equalsIgnoreCase(prefix+"pfp")){
                
                EmbedBuilder embed1 = new EmbedBuilder();
                embed1.setColor(Color.cyan);
                
                if(event.getMessageContent().length()==4){
                    embed1.setTitle(event.getMessageAuthor().getName()+" Profile Picture");
                    embed1.setImage(event.getMessageAuthor().getAvatar().getUrl()+"?size=1024");
                }
                else{
                    embed1.setTitle(event.getMessage().getMentionedUsers().get(0).getName()+"'s Profile Picture");
                    embed1.setImage(event.getMessage().getMentionedUsers().get(0).getAvatar().getUrl()+"?size=1024");
                }

                event.getChannel().sendMessage(embed1);
            }

            if(event.getMessageContent().equalsIgnoreCase(prefix+"help")){
                EmbedBuilder embed2 = new EmbedBuilder();
                embed2.setColor(Color.YELLOW);
                embed2.setTitle("BOT COMMANDS");
                embed2.setDescription("Following Commands can be used with this Bot:");
                embed2.addField("Prefix", "$");
                embed2.addField("help", "Shows the bot commands");
                embed2.addField("q", "Sends a Motivational, Positive, Inspirational quotes");
                embed2.addField("pfp", "Sends the profile picture");
                event.getChannel().sendMessage(embed2);
            }
                });
        
    }

    
    
    public static void quote() {
        System.out.println();

        Random rand = new Random();

        String  QUOTES[] = {
            "https://i.ibb.co/q72LFTx/bryce-koch-KGedr-LRVMQo-unsplash.jpg",
            "https://i.ibb.co/xGNVQZ8/jon-tyson-o-Kwm-Vr2y-UV4-unsplash.jpg",
            "https://i.ibb.co/JrmqgSh/peter-fogden-z7oyt-XGI6-VI-unsplash.jpg",
            "https://i.ibb.co/QJTk91Z/chris-curry-UJij-wz7w88-unsplash.jpg",
            "https://i.ibb.co/YR2SC67/morgan-housel-Xl-6-Wjqcpp-Q-unsplash.jpg",
            "https://i.ibb.co/Y0gx3Gr/toa-heftiba-z9snu-Pi-PKg-Q-unsplash.jpg",
            "https://i.ibb.co/frHkHRZ/alysha-rosly-vb2q-WEax4p-M-unsplash.jpg",
            "https://i.ibb.co/6nX7nL2/ty-williams-R2gln-KGBo-PE-unsplash.jpg",
            "https://i.ibb.co/tmKQ4vK/james-healy-WZ-Ynv-CCLug-unsplash.jpg",
            "https://i.ibb.co/0yMMf5g/cristofer-jeschke-NSKP7-Gwa-I0-unsplash.jpg",
            "https://i.ibb.co/8Xj9P0M/hello-i-m-nik-z1d-LP8sju-I-unsplash.jpg",
            "https://i.ibb.co/7g03Sb9/anthony-garand-7-Rx-Ms-Jdvt7k-unsplash.jpg",
            "https://i.ibb.co/LxwBp4f/mert-talay-KYZo-Ompn1-Aw-unsplash.jpg"                         
            };

        url = QUOTES[rand.nextInt(QUOTES.length)];

    }
}