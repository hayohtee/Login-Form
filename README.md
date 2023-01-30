# Login-Form
A simple android app for simulating Login functionality


## Aim
The aim of this activity is to create a login form with username and password fields.
Once the values in these fields are submitted, check these entered values against
hardcoded values and display a welcome message if they match, or an error message
if they don't, and return the user to the login form. 
The steps needed to achieve this are the following:

## Steps
1. Create a form with username and password EditText Views and
a LOGIN button.
2. Add a ClickListener interface to the button to react to a button press event.
3. Validate that the form fields are filled in.
4. Check the submitted username and password fields against the
hardcoded values.
5. Display a welcome message with the username if successful and hide the form.
6. Display an error message if not successful and redirect the user back to
the form.

## My Approach
Use startActivityForResult to carry out the validation in another Activity
and then return the result.
