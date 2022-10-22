## Battles

### Overview

This is a model of a battle game, it needs to represent different kinds of player, weapon, gear, and other attributes. I designed a hierachy sturcture and enumeration denotion to help construct this model.

### Features
* Calculator. 
    There is a `PlayerCalculator` interface that does all the 'dirty' work of calculating, and setting the Players free from tedious processes.
* Organized Information
    All information are stored in `Map<GameInfoKey, Object>` instead of String, easy to edit and reformat.
* Clear Structure
    The structure has been re-designed so it's very clear and readable.
* Good Extension. 
    In future, it's very easy to extend with other Calculators. Just implement new Classes and replace it in the Game Model.
* Independent Random Helper
    All random processes are summed into the RandomHelper and easy for extending or modifying.

### How to run

If you have JRE installed on your environment, double click the runnable jar`./res/jar/p2-battles-runnable.jar` is fine enough.<br/>
Or in the terminal, put in command
`java -jar ./res/jar/p2-battles-runnable.jar` <br />
*Note*: Don't delete the `./res/jar/res` folder! It's critical.
The output will be in `./res/jar/res/runningResult.txt` or `./res/runningResult.txt`.

### Useage

You are encouraged to import the public classes and discover the extendable features in it.
Like `import game.BattleGame` and call all its functions. <br />
There are several functions in it that will return complicated Map Object, because we designed it to be so for multi-layer information.<br />
It would be a great idea to `import org.json.JSONObject;` by configuring `Maven` and call 
```
JSONObject json = new JSONObject(map);
System.out.println(json);
```
to see the bigger image of the Map structure.<br />
Note that the `key` of the information map are all of Enumeration `game.GameInfoKey`.<br />

### Examples

The Example basically initiated the battle game with two players, printing out their attributes, and started the game of attacking each other, and print their details. The running result is full of promotion words. <br />
At one point, it will ask for your input as : `Now input 're' to RE-match them:`. Please press `re` and `Enter` to continue. <br />
You can change the parameters in the `setUp3()` function.

### Design

One BIG change I made was I added a whole new Interface : PlayerCalculator. It will take all the dirty work, like calculating or assigning the values from RandomHelper. The benefit of this is that in case we want a new algorithm or method of finding the damages, just implement a new calculator and let the game model switch to this one. Then it's all set! I did this in the Unit Tests. <br>
By doing so, our Player implementations are seperated from the calculation work, only maintaining the model datas.

### Assumptions

* Gear Term Upper Bound is 50. But you can simply change this by implementing other RandomHelper and replace it to initialize the Calculator.
* Users of this class will need a returned Map rather than a large String because they might need to reformat the information.
* Attack damage and health and all attributes are in Integer format.
* We generate a list of Gear that has all types of the Gear (regardless of the Size).

### Limitations

* The design encapsualed the armory and bag of gears inside the RandomHelper, not exposing to other classes. So if you want to have different combination, you need to re-implement another RandomHelper, as we did in the Test.

### Citations

I couldn't find it again, but it was a post on GeeksForGeeks talking about game design. And it was its words 'calculation should be independent' that motivated me to seperate the Calculator interface from the Player. But I failed to find the link now.