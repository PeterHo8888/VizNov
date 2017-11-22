# VizNov
Visual Novel Engine

Note: You must add at least 1 background and character image in their 
corresponding directory in  ./res.

Bg files are .png or .jpg, and characters are just .png.

Please note that the novel as of current does not automatically scale...
You'll need to manually scale your images to fit, or maybe add it for me 
:)

See res/game.scr for an example script.

# Text
Text is literally just in quotes.

Example:

`"Hello!"`

I haven't added functionality for which character is saying what yet.


# Backgrounds
Basically, setting the background works like this:

`bg [file name]`

where [file name] is not in quotes but rather just typed out w/out the 
extension.  So if I have a file "peter home.png", I would type:

`bg peter home`

to display the bkgrnd.

# Characters
Same thing applies to drawing characters, except 
now there are more parameters:

`draw [file name] [position/x y]`

Example:

```
draw peter sad middle
draw peter happy 100 100
```

You can also "hide" characters, which essentially just means removing 
them.

`hide peter sad`

# Jumps
There are no conditions yet, but you can jump just like you would in 
assembler with labels.

```
start:
draw peter angry middle
"hello"
hide peter angry
"goodbye"
jmp start
```
