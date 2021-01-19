import 'react-native-gesture-handler';
import { StatusBar } from 'expo-status-bar';

import React from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';
import LoginScreen from './src/screens/loginScreen';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

const Stack = createStackNavigator();
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import TodoScreen from './src/screens/todoScreen';
import AddTodo from './src/screens/addTodoScreen';

export default function App({navigation}) {

  return (
    <NavigationContainer>

    <Stack.Navigator>
        <Stack.Screen
          name="login"
          component={LoginScreen}
          options={{ title: 'Welcome' }}
        />
        
        <Stack.Screen name="todo" component={TodoScreen} options={{headerShown: false}}/>

        <Stack.Screen name="addtodo" component={AddTodo} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
