1) QuickTipAlgorithmULType implements AbstractQuickTipAlgorithmARN

<upperLimit>90</upperLimit>
<amountRandomNumbers>5</amountRandomNumbers>
...

return value : one panel filled in : ^ 5 random numbers 1..90 in this example

2) QuickTipAlgorithmAPType implements AbstractQuickTipAlgorithmARN

...
<amountRandomNumbers>5</amountRandomNumbers>
<amountOfPanels>3</amountOfPanels>

<upperLimit>90</upperLimit> : not specified 90 understood

return value : 3 panels filled in : ^ 5 random numbers 1..90 each in this example

3) QuickTipAlgorithmULAPType implements AbstractQuickTipAlgorithmARN
<upperLimit>90</upperLimit>
<amountOfPanels>3</amountOfPanels>
<amountRandomNumbers>5</amountRandomNumbers>

return value : 3 panels filled in : ^ 5 random numbers 1..90 each in this example

-------------------------------------------------------------

Input parameters : <amountOfPlaySlips> <quickTipAlgorithmNo>

Remark :
play slip / ticket sheet - is the whole betting unit

It is provided that the configuration XML and XSD files are in the actual directory,
with the following names :
QuickTip.xml - the configuration file
QuickTip.xsd - the configuration file's schema

