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
