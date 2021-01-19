import React from 'react';
import {Button, Text,View} from 'react-native';
import { TouchableOpacity } from 'react-native';

import { useEffect } from 'react/cjs/react.development';
import styles from './style'
const TodoListCard = (props) =>{
    useEffect(()=>{
        console.log(props);
    },[]);
    return(
        <View  style={styles.cardContainer}>
            <View style={styles.card} >
                <View>
                <Text><Text style={{fontWeight:"bold"}}>Title -</Text> {props.todoListData.title}</Text>
                <Text><Text style={{fontWeight:"bold"}}>Description -</Text> {props.todoListData.description}</Text>
                </View>
            
            <TouchableOpacity onPress={()=>props.deletetodo(props.index)} style={styles.deletebtn}>
            <Text>Delete</Text>
            </TouchableOpacity>
            </View>
           
    </View>
    );
}
export default TodoListCard;