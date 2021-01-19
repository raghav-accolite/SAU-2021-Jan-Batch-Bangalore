import React, { useEffect,useState } from 'react';
import {View, TextInput, TouchableOpacity,Text} from 'react-native';
import styles from './styles';
import { useHistory,Redirect } from "react-router-dom";
import AsyncStorage from '@react-native-community/async-storage';
const LoginScreen = ({ navigation }) =>{
  
    const [userName, setUserNameState] = useState("");
    const history = useHistory();
     useEffect(() =>{
      (async () => {
        console.log(await AsyncStorage.getItem("username"));
        try {
          //await AsyncStorage.removeItem("username");
          if( await AsyncStorage.getItem("username")!==null){
            navigation.reset({
              index: 0,
              routes: [{ name: 'todo' }],
            });
            //navigation.Redirect('todo');
            
            //history.push("todo");
          }
        } catch (error) {
          return;
        }
      })();         
    },[]);
    const loginUser = () =>{
      (async () => {
        console.log("login user");
        await AsyncStorage.setItem(
          "username",userName
        );
        navigation.reset({
          index: 0,
          routes: [{ name: 'todo' }],
        });
        //navigation.Redirect('todo');
        // navigation.push('todo');
          //history.push("todo");
      })();    
      
    }
    return(
        <View style={styles.container}>
        <TextInput  
          style={styles.inputText}
          placeholder="username" 
          placeholderTextColor="#003f5c"
          onChangeText={text => setUserNameState(text)}/>

          <TouchableOpacity onPress={()=>loginUser()} style={styles.loginBtn}>
          <Text  style={styles.loginText}>LOGIN</Text>
        </TouchableOpacity>
      </View>

    );

}
export default LoginScreen;