import React, { useEffect,useState } from 'react';
import {View, TextInput, TouchableOpacity,Text, ScrollView} from 'react-native';
import styles from './styles';
import { useHistory } from "react-router-dom";
import { Appbar } from 'react-native-paper';
import TodoListCard from '../../components/todo-list-card';
import AddTodo from '../addTodoScreen';
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";
  import AsyncStorage from '@react-native-community/async-storage';
const TodoScreen = (props) =>{
  
    const history = useHistory();
    const [todoList, setTodoList] = useState([]);
    useEffect(() =>{
      if(props.route.params === undefined){
          console.log("UNDEFINED",props);
        (async function() {
            if(await AsyncStorage.getItem("todolist") == null){
                return;
            }
            else{
                const storedList = await AsyncStorage.getItem("todolist");
                setTodoList([...JSON.parse(storedList)]);
            }
        })();
      }
      else{
        (async function() {
            
            console.log("DEFINED");
            console.log(props.route.params.title);
            AsyncStorage.getItem("todolist").then((value)=>{
                console.log(JSON.parse(value));
                if(value==null){
                    setTodoList([{title:props.route.params.title.text,description:props.route.params.description.text}]);
                       
                }
                else{
                    setTodoList([...(JSON.parse(value)),
                        ...[{title:props.route.params.title.text,description:props.route.params.description.text}]]);   
                }
            });          
        })();
      }      
      
    },[props.route]);
    
    useEffect(()=>{
        (async function() {
            AsyncStorage.setItem("todolist",JSON.stringify(todoList)).then((value)=> {
                console.log(todoList);
            });        
        })();

    },[todoList]);

    const NavigateToAddTodoScreen = () =>{
        props.navigation.navigate('addtodo');
        //history.push('/add-todo');
    }
    const DeleteTodo = (key) =>{
        console.log("DELETE TODO CLALLED");
        (async function() {
            AsyncStorage.getItem("todolist").then((value)=> {
                let temp = JSON.parse(value);
                temp.splice(key, 1);
                setTodoList(temp);
            });        
        })();
    }
    return(
        
        <View >
        <Appbar.Header>
        <Appbar.Content title="To-Do" subtitle={'Save Notes'} />
            <Appbar.Action icon="plus" onPress={()=>NavigateToAddTodoScreen()} />
        </Appbar.Header>
            
       <View style={styles.container}>
        <ScrollView >
        {todoList.length >0 ?(
                todoList.map((todo,index) => <TodoListCard todoListData={todo} key={index} deletetodo={()=> DeleteTodo(index)}/>)
            ):(
                <Text>
                    No Todo work              
                </Text>
            )
            }
        </ScrollView>
        </View>
        </View>

    );

}
export default TodoScreen;
