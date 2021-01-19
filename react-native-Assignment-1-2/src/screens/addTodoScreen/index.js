import React, { useState } from 'react';
import {View,Text,TextInput, Button} from 'react-native';
import styles from './style';
import { useHistory,Redirect } from "react-router-dom";

const AddTodo = (props) =>{
    const [todoTitle,setTitle] = useState("");
    const [todoDescription,setDescription] = useState("");
    const history = useHistory();
    const AddTodo= ()=>{
        props.navigation.navigate('todo',{ title: todoTitle,description:todoDescription });
       // history.push('/todo', { title: todoTitle,description:todoDescription });
      
    }
    return(
        <View style={styles.view}>
             <TextInput style = {styles.title}
               underlineColorAndroid = "transparent"
               placeholder = "Title"
               placeholderTextColor = "#9a73ef"
               autoCapitalize = "none"
               onChangeText = {(text)=>setTitle({text})}/>
               <TextInput style={styles.description}
                multiline={true}
                numberOfLines={6}
                onChangeText={(text) => setDescription({text})}/>
                <Button   title="Add" color="#841584" onPress={() => AddTodo()}/>

        </View>
    );
}
export default AddTodo;