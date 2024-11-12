Particle Simulation Project

Author: Shree Vats
Roll : 23BDS055

Project Overview
This project simulates the behavior of particles in a 3D space. 
It reads data from a CSV file containing particle properties, computes their velocity magnitude, momentum, and kinetic energy, and saves these computed metrics into separate output files. 
The simulation results are visualized through various plots for analysis.


Folder Overview
Particle-Simulation/
├── src/
│   ├── ParticleSimulation.java     # Main simulation code
├── data/
│   ├── large_particle_system_dataset.csv  # Input dataset
│   ├── velocities.csv              # Output file: velocities of particles
│   ├── momenta.csv                 # Output file: momenta of particles
│   ├── kinetic_energies.csv        # Output file: kinetic energies of particles
├── plots/                          # Optional folder for visualizations
│   ├── momentum_vs_energy.png      # These diagram is included in the javaoutputvisulisation.ipynb file
│   ├── velocity_distribution.png
│   ├── kinetic_energy_boxplot.png
├── README.md                       # Project documentation
├── output/                         # Folder for generated files
│   ├── velocities.csv
│   ├── momenta.csv
│   ├── kinetic_energies.csv



