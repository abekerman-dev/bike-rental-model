## Design

This repo is a simple maven project which models a bike rental company operating with the following rental logic:

 1. Rental by hour, charging $5 per hour
 2. Rental by day, charging $20 a day
 3. Rental by week, changing $60 a week
 4. Family Rental - a promotion that can include from 3 to 5 Rentals (of any type) with a discount of 30% on the total price

The code design essentially follows these conditions, and hence features a ``Rental`` interface as the root model which in turn is implemented by "time-boxed" rentals on the one hand (``DailyRental``, ``HourlyRental``, and ``WeeklyRental``) and a ``FamilyRental`` model on the other (featuring the logic mentioned in 4.).

The ``Rental`` interface exposes a single method, ``getTotalCost()``, which is implemented by each different rental type according to their own business rules.

The "productive" code does not include a ``main`` method (or entry-point) as the exercise only requested to implement the bike rental company domain model and its corresponding unit tests.

## Development Practices Applied

Since the exercise was not too complex to code (being that it consisted only of modeling the domain), there were not too many "good practices" to follow or to adhere to.

However, the key good development practice applied here is the notion of **"programming against interfaces"** and the use of **inheritance** and **polymorphism** to leverage code extensibility, maintainability, and testability.

Other than that, ``BigDecimal`` was used to represent money-related information as recommended [here](http://www.javapractices.com/topic/TopicAction.do?Id=13).

Finally, unit tests were designed with simple mock-returning static getters in mind due to the simplicity of scenarios being tested and especially due to the fact that this code features no real-life, production-like dependencies (in which case more powerful frameworks such as [Mockito](https://site.mockito.org/) should be favored).

## How to run the tests

The tests are simple unit tests embodied in one catch-all Junit class, ``AllTestCases``, and can be run either with ``mvn clean package`` or via an IDE such as Eclipse.
