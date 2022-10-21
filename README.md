# JDA-Wrappers

- [Usage](https://github.com/jman13378/JDA-Wrappers#usage)
    - [Listener](https://github.com/jman13378/JDA-Wrappers#Listener)
    - [Slash Commands](https://github.com/jman13378/JDA-Wrappers#slash-commands)
    - [Text Commands](https://github.com/jman13378/JDA-Wrappers#text-commands)
- [License](https://github.com/jman13378/JDA-Wrappers#License)


## Usage

### Listener

1. Create a listener class 
2. Make the class extend [ListenerAdapter](https://ci.dv8tion.net/job/JDA5/javadoc/net/dv8tion/jda/api/hooks/ListenerAdapter.html) `public class foobar extends ListenerAdapter {...}`
3. Add 2 methods and a [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)™
    - [`@SuppressWarnings({ "unchecked", "rawtypes" })
    private static final HashMap<String, SlashCommand> commands = new HashMap();`](https://github.com/jman13378/JDA-Wrappers/blob/main/SlashCommand/examples/listener.java#L36)
    - [`public foobar() {...}`](https://github.com/jman13378/JDA-Wrappers/blob/main/SlashCommand/examples/listener.java#L38)
    - @Override [`public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {...}`](https://github.com/jman13378/JDA-Wrappers/blob/main/SlashCommand/examples/listener.java#L46)
4. Add your slash commands within your listener [example](https://github.com/jman13378/JDA-Wrappers/blob/main/SlashCommand/examples/listener.java#L40)

### Slash Commands

1. Create a Java class
2. Make the class extend [SlashCommand](https://github.com/jman13378/JDA-Wrappers/blob/main/SlashCommand/SlashCommand.java) `public class foobar extends SlashCommand {...}`
3. Add the methods 
    - `public void execute(SlashCommandEvent event) {...}`
    - `public foobar() { super(String command) }`
4. Add your code

### Text Commands

#### TBA

## License

MIT License

Copyright (c) 2022 jman13378

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
