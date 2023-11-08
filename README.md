# Task Scheduling Optimizer

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Scheduling Algorithms](#scheduling-algorithms)
- [Data Files](#data-files)
- [Getting Started](#getting-started)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project is a Task Scheduling System designed to help manage and optimize the scheduling of production tasks within an organization. It provides a flexible framework to allocate tasks to employees based on priority, due dates, and dependencies, ensuring efficient production scheduling.

## Features

- [x] **Task Allocation**: Assign tasks to employees based on type, availability, and constraints.
- [ ] **Dynamic Scheduling**: Optimize production schedules dynamically with advanced algorithms.
- [x] **Output Generation**: Create output schedule files for sharing and in-depth analysis.
- [x] **Priority for Tasks**: Tasks can have priority.
- [x] **Task Dependencies**: Dependencies support for tasks.

## Project Structure

The project is organized into the following main components:

- `scheduling`: Contains classes related to the scheduling system.
- `tasks`: Contains classes related to task management.
- `employees`: Contains classes for defining employee characteristics.

## Scheduling Algorithms

- PriorityDueDateSchedulingAlgorithm: Allocates tasks based on importance (Priority / Due Date).
- You can add additional scheduling algorithms by implementing the `SchedulingAlgorithm` interface.

## Data Files

- You can load task and employee data from CSV files.
- Modify the CSV files in the `data` folder to define tasks and employee attributes.

## Getting Started

1. Add your data for tasks and employee in data folder.
2. Run the main program (`Main.java`) to access the scheduling menu.
3. Choose options to apply a scheduling algorithm or save results to a file.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests to improve the project.

## License

This project is licensed under the MIT - see the [LICENSE.md](LICENSE.md) file for details.
