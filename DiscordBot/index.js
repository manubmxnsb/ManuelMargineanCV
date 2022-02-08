const Discord = require('discord.js');
const { prefix, token, giphyToken } = require('./config.json');
const { roastText, praise_array, slap_array, spank_array, kill_array, stare_array, feed_array, punch_array, 
wink_array, hug_array, salute_array, laugh_array, boop_array, kiss_array, drink_array, eat_array } = require('./roast.js');
const GphApiClient = require('giphy-js-sdk-core');
const client = new Discord.Client();
const giphy  =  GphApiClient(giphyToken);

client.once('ready', () => {
    console.log(' Ready !')
})

client.on('message', message => {

    if (message.member.hasPermission(['KICK_MEMBERS', 'BAN_MEMBERS'])) {
        if(message.content.startsWith(prefix + 'kick')) {
            let member = message.mentions.members.first();
            let role = message.mentions.members.first().roles.cache;
            let botrole = message.guild.roles.cache.find(name => name === 'V1 Test Bot');
            if (member)
                if (role < botrole){
                    member.kick().then((member) => {
                        message.channel.send(":wave: " + member.displayName + " has been kicked!")})
                }
                else
                {
                    message.channel.send("I can't kick this member. Try moving my role higher than theirs.");
                }
            else
                    message.channel.send("Make sure to @mention who you want to be kicked!");
        }
    }

    if (message.member.hasPermission(['KICK_MEMBERS', 'BAN_MEMBERS'])) {
        if(message.content.startsWith(prefix + 'ban')) {
            let member = message.mentions.members.first();
            let role = message.mentions.members.first().roles.cache;
            let botrole = message.guild.roles.cache.find(name => name === 'V1 Test Bot');
            if (member)
                if (role < botrole){
                    member.ban().then((member) => {
                        message.channel.send(":name_badge: " + member.displayName + " has been banned!")})
                }
                else
                {
                    message.channel.send("I can't ban this member. Try moving my role higher than theirs.");
                }
            else
                    message.channel.send("Make sure to @mention who you want to be banned!");
        }
    }

    if (message.content.startsWith(prefix + 'avatar'))
    {
        const member = message.mentions.users.first() || message.author;
        const avatarEmbed = new Discord.MessageEmbed()
        .setColor(0xFFC300)
        //.setAuthor(member.username)
        .setTitle(member.username + '`s Avatar')
        .setImage(member.displayAvatarURL() + "?size=256");
        message.channel.send(avatarEmbed);
    }

   if(message.content.startsWith(prefix + 'poll'))
   {
       let args = message.content.substring(prefix.length).split(" ");
       const pollEmbed = new Discord.MessageEmbed()
       .setColor(0xFFC300)
       .setTitle("Initiate poll")
       .setDescription('Use command !poll "Question?" "Answer1" "Answer.." to create a poll.')
       .setFooter('Poll made by : ' + message.author.username);
       pollEmbed.description = (pollEmbed.description);
       if(!args[1]) {
           message.channel.send(pollEmbed);
           return;
       }
       else
       {
            //pollEmbed.title = ("📋 " + "**" + args[0] + "**");    
       }
       let pollArgs = args.slice(1).join(" ");
       args = pollArgs.substring(1,pollArgs.length-1).split('" "');
       pollEmbed.title = ("📋 " + "**" + args[0] + "**");
       let i = 0;
       while (i < args.length)
       {
           if(args[1]) {
                pollEmbed.description = ("1️⃣ " + args[1]); 
           }
           if(args[2]) {
                pollEmbed.description = (pollEmbed.description + "\n" + "2️⃣ " + args[2]);
           }
           if(args[3]) {
                pollEmbed.description = (pollEmbed.description + "\n" + "3️⃣ " + args[3]);
           }
           if(args[4]) {
                pollEmbed.description = (pollEmbed.description + "\n" + "4️⃣ " + args[4]);
           }
           if(args[5]) {
                pollEmbed.description = (pollEmbed.description + "\n" + "5️⃣ " + args[5]);
           }
           i++;
       }
       message.channel.send(pollEmbed).then(messageReaction => {
            
            if(args[1]) {
                messageReaction.react("1️⃣");
                }
            if(args[2]) {
                messageReaction.react("2️⃣");
                }
            if(args[3]) {
                messageReaction.react("3️⃣");
                }
            if(args[4]) {
                messageReaction.react("4️⃣");
                }
            if(args[5]) {
                messageReaction.react("5️⃣");
                }
            message.delete({ timeout: 5000 })
       })
   }

   if(message.content.startsWith(prefix + 'csgo'))
    {
        let args = message.content.substring(prefix.length).split(" ");
        args = args.slice(1);
        while(args.length>5)
        {
            let math = Math.floor(Math.random() * Math.floor(args.length));
            args.splice(math,1);
        }
        let players = "";
        args.forEach(function (item, index) {
            players = players + "**" + (index+1) +".** " + item + '\n';
        });
        message.channel.send("**" + "The Team " + "**" + "has been made!" + '\n' + '\n' + "**" + "The Players are : " + "**" + '\n' + players).then(message.delete ({ timeout: 5000}));
    }

    if(message.content.startsWith(prefix + 'roast'))
    {
        const victim = message.mentions.members.first();
        if(victim){
            const RoastEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription(victim.displayName + roastText[(Math.floor(Math.random()* (roastText.length)))])
            .setFooter(message.author.username + "'s roast for " + victim.displayName);
            message.channel.send(RoastEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention who you want to roast!");
        }
    }

    if(message.content.startsWith(prefix + 'gif'))
    {
        let words = message.content.substring(prefix.length).slice(4).split(" ").join('-');
        if(!words[0])
        {
            message.channel.send('Make sure to @mention tags for gif!')
        }
        else
        {
            giphy.search("gifs", { q: words }).then(response => {
                var totalResponses = response.data.length;
                var responseIndex = Math.floor((Math.random() * 10) + 1) % totalResponses;
                var responseFinal = response.data[responseIndex]
                message.channel.send({
                    files: [responseFinal.images.fixed_height.url]
                })
                console.log(words);
            });
        }
    }

    if(message.content.startsWith(prefix + 'praise'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let praiseEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' is praising ' + '**' + user.displayName + '**' + '! :partying_face:')
            .setImage(praise_array[0] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(praiseEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to praise!");
        }
    }

    if(message.content.startsWith(prefix + 'slap'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let slapEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' slapped ' + '**' + user.displayName + '**' + '! :clap:')
            .setImage(slap_array[Math.floor((Math.random() * (slap_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(slapEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to slap!");
        }
    }

    if(message.content.startsWith(prefix + 'spank'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let spankEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' spanked ' + '**' + user.displayName + '**' + '! :face_with_hand_over_mouth:')
            .setImage(spank_array[Math.floor((Math.random() * (spank_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(spankEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to spank!");
        }
    }

    if(message.content.startsWith(prefix + 'kill'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let killEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' wants to kill ' + '**' + user.displayName + '**' + '! :zap:')
            .setImage(kill_array[Math.floor((Math.random() * (kill_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(killEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to kill!");
        }
    }

    if(message.content.startsWith(prefix + 'stare'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let stareEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' stares at ' + '**' + user.displayName + '**' + '.. :hushed:')
            .setImage(stare_array[Math.floor((Math.random() * (stare_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(stareEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to stare at!");
        }
    }

    if(message.content.startsWith(prefix + 'feed'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let feedEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' is feeding ' + '**' + user.displayName + '**' + '! :pizza:')
            .setImage(feed_array[Math.floor((Math.random() * (feed_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(feedEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to feed!");
        }
    }

    if(message.content.startsWith(prefix + 'punch'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let punchEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' punched ' + '**' + user.displayName + '**' + '! :call_me:')
            .setImage(punch_array[Math.floor((Math.random() * (punch_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(punchEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to punch!");
        }
    }

    if(message.content.startsWith(prefix + 'wink'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let winkEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' winked at ' + '**' + user.displayName + '**' + '! :shushing_face:')
            .setImage(wink_array[Math.floor((Math.random() * (wink_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(winkEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to wink at!");
        }
    }

    if(message.content.startsWith(prefix + 'hug'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let hugEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' hugged ' + '**' + user.displayName + '**' + '! :hugging:')
            .setImage(hug_array[Math.floor((Math.random() * (hug_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(hugEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to hug!");
        }
    }

    if(message.content.startsWith(prefix + 'salute'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let saluteEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' salutes ' + '**' + user.displayName + '**' + '! :raised_hands:')
            .setImage(salute_array[Math.floor((Math.random() * (salute_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(saluteEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to salute!");
        }
    }

    if(message.content.startsWith(prefix + 'laugh'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let laughEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' laughs at ' + '**' + user.displayName + '**' + '! :joy: ..Or with?')
            .setImage(laugh_array[Math.floor((Math.random() * (laugh_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(laughEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to laugh at!");
        }
    }

    if(message.content.startsWith(prefix + 'boop'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let boopEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' boops ' + '**' + user.displayName + '**' + '! :star2:')
            .setImage(boop_array[Math.floor((Math.random() * (boop_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(boopEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to boop!");
        }
    }

    if(message.content.startsWith(prefix + 'kiss'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let kissEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' kissed ' + '**' + user.displayName + '**' + '! :smiling_face_with_3_hearts:')
            .setImage(kiss_array[Math.floor((Math.random() * (kiss_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(kissEmbed);
        }
        else
        {
            message.channel.send("Make sure to @mention the person that you want to kiss!");
        }
    }

    if(message.content.startsWith(prefix + 'drink'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let drinkEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' drinks with ' + '**' + user.displayName + '**' + '! :tropical_drink:')
            .setImage(drink_array[Math.floor((Math.random() * (drink_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(drinkEmbed);
        }
        else
        {
            let drinkEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' drinks some :tropical_drink:')
            .setImage(drink_array[Math.floor((Math.random() * (drink_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(drinkEmbed);
        }
    }

    if(message.content.startsWith(prefix + 'eat'))
    {
        let user = message.mentions.members.first();
        if(user)
        {
            let eatEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' eats with ' + '**' + user.displayName + '**' + '! :taco:')
            .setImage(eat_array[Math.floor((Math.random() * (eat_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(eatEmbed);
        }
        else
        {
            let eatEmbed = new Discord.MessageEmbed()
            .setColor(0xFFC300)
            .setDescription('**' + message.author.username + '**' + ' eats some :taco:')
            .setImage(eat_array[Math.floor((Math.random() * (eat_array.length)))] + "?size=256")
            .setFooter("Powered by Tenor");
            message.channel.send(eatEmbed);
        }
    }

    if(message.author.bot)
    {
        return;
    }   

    
})

client.login(token);
