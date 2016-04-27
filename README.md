# energy.data.gen

This repository contains a generator of energy data in N-Triple format

User should provide 7 parameters to the [main class](https://github.com/spaseq/energy.data.gen/blob/master/src/main/java/fr/ujm/curien/krr/smart/generator/main/MainGenerator.java) : parameters [p1, p2] for the price range of renewable energy and [p3, p4] for the price range of energy produced using fuel (the 4 prices) and  homeC-environmental, homeC-generation and homeC-power (the 3 input folders). 

This is an example using the jar file : java -jar [energyDataGen.jar](https://github.com/spaseq/energy.data.gen/blob/master/energyDataGen.jar) 30 35 40 45 [homeC-environmental/](https://github.com/spaseq/energy.data.gen/tree/master/src/main/resources/homeC-all/homeC-environmental) [homeC-generation/](https://github.com/spaseq/energy.data.gen/tree/master/src/main/resources/homeC-all/homeC-generation) [homeC-power/](https://github.com/spaseq/energy.data.gen/tree/master/src/main/resources/homeC-all/homeC-power) 
