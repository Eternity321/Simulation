# Life simulation

## Description
- The essence of the project is a step-by-step simulation of a 2D world inhabited by eaters and predators. In addition to existence, the world contains
  resources (grass) that feed on herbivores and static objects with which global communities cannot interact - they simply
  leave space.

## Simulation criteria
- The simulation ends when there is not a single herbivore or predator left in the world.

## Simulation modes
### Adding support for two simulation modes:
- Step mode: In this mode, the user selects the next step of the simulation and can observe the current state.
  ecosystems.
- Automatic mode: Performance simulation is performed without following user requirements.

## Hunting and getting food
- Herbivores eat plants, such as grass. They move around the world in search of food.
- Predators hunt herbivores. They move around the world trying to catch and eat herbivores.
- Lack of food: if there are not enough plants in the world for herbivores or herbivorous predators, they may die from
  hungry.