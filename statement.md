\# Problem Statement Harmful Substance \& Additive Risk Detector



\## 1.Problem Statement

Modern processed foods contain numerous additives, preservatives, artificial colorings, and flavor enhancers.Many of these ingredients carry potential health risks—ranging from allergic reactions and hyperactivity to metabolic dysfunction or may even be banned in certain international jurisdictions. Average consumers often lack thedomain knowledge to evaluate complex ingredient labels or understand how specific additives interact with their personal profile,such as age and BMI. 



\## 2. Scope of the Project

This project provides a rule-based Java application designed to analyze food ingredients and match them against known chemical additives and user physical parameters. .



In Scope

&#x20;Capturing user parameters (Age, Gender,Weight, Height) and computing BMI classification.

&#x20;Cataloging known harmful additives, toxicity levels,aand banned substance indicators.

&#x20;Cross-referencing product ingredient lists against user metrics to generate personalized metabolic warnings.

&#x20;Interactive Command Line Interface (CLI) for catalog scanning and manual ingredient lookups.



Out of Scope (Phase 1)

&#x20;Real-time web scrapingexternal REST API integrations (planned for future enhancement).

&#x20;Image recognition  OCR label scanning.



\## 3. Target Users

&#x20;Health-Conscious Consumers Individuals seeking transparency regarding processed food ingredients..

&#x20;Parents Caregivers monitoring additive intake (e.g.. artificial dyes) restricted for young children.

&#x20;Individuals with Specific Metabolic Profiles Users managing weight or high BMI who need to avoid high fructose corn syrup and transfats.



\## 4. High-Level Features

&#x20;UserProfile Management Real time BMI calculation and age-bracket categorization.

&#x20;Additive Registry In-memory local database mapping ingredients to risk tiers(LOW, MEDIUM, HIGH, BANNED)and documented health effects.

&#x20;Personalized Assessment Engine Rule engine evaluating additive contraindications based on user age and BMI.

&#x20;CLI Reporting Interface Formatted output presenting critical warnings, banned substance alerts,aand metabolic advisories.

