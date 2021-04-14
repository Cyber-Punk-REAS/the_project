# Classes

## Person

- IsInmune
- Chance to infect
- Chance to be infected
- Chance to go out at night
- Number of businesses visited per day

## InfectedPerson (extends `Person`)

- Days until cured
- IsQuarentined
- Chance of dying

## Business

- Type
- Maximum # of people
- Outdoors or indoors.

## Region

- List of `Person`s
- List of `Business`es
- Prevention measures (maybe?)

## Simulation

- List of `Region`s
- List of `Restriction`s
- **BeginSim(NDays)** . Begins the simulation and returns a list of days with each day passed.
- **Constructor(NRegions,List or Array with the number of people in each region, List or Array with the number of businesses in each region,NDays)** . Class constructor. Also creates the array or List of regions needed.
- **AddRestriction(Restriction)** . Adds a restriction to the List.

## Restriction (Abstract) 

- Reduction of the infection chance.
- Percentage of businesses closed. (If it doesnt affect businesses then 0%).

## Day

- Number of infected. Could be a list with the number of infected of each region.
- Number of deaths. Same with infected.
- Number of total people. Same.
- Number of inmune people. Same.

## Compare

- **Comparison(List of List of Days)** . Compares the results of different simulations. Shows on Console or maybe other means the data and then the Winner simulation based on terms of efficacy.
