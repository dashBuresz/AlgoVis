Plans for GUI:
    in the graph visualizer I think the functionality should be the following, for the buttons:
| Button        | Functionality Description |
|--------------|--------------------------|
| **Generate Graph** | If all the parameters are given correctly, for example, in the text-field there are only positive numbers entered, we generate the graph and show it on the left-hand side. However, if the conditions aren't met, the user will get an error popup with a message and an OK button. |
| **Add Edge** | The user will get a pop-up with a message saying "Please select the two end-nodes" and a button saying either "To Selection" or "OK". The GUI should get a new button until selection is active called "Complete Selection," but this is just a concept and subject to change. If the user selected correctly and pressed the button that indicates the completion of selection, the graph will be updated with the new edge. We also need to take care of assigning weights if needed. |
| **Add Vertex** | This one is simple. The user presses the button, and the graph will be updated with an isolated vertex. |
| **Remove Edge** | The user will be prompted, just as above, to select an edge and will also be able to confirm selection as explained above. If the selection is correct, the operation is complete; otherwise, an error message will show. |
| **Remove Vertex** | Similar to "Remove Edge," this button removes a vertex, but also all of the edges that connect to said vertex. Correct and incorrect inputs will be handled as above. |
