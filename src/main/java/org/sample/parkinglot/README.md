Requirements:

1. User should be able to park his car at particular spot.
2. System should be able to calculate parking charges.
3. User should be able to exit after paying the charges.

Design Patterns used :
Factory + Strategy --> Payment logic + Parking charges calculation

Workflow considered :
User arrives —> system checks the spot —> if available —> assign the sport  —> car parked at spot —> unpark -> free up the spot --> calculate charges —> pay amount —> get receipt.