/*import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

const App = () => {

  const defaultState = {
    counter1: 0,
    counter2: 0
  }

  const [counter, setCounter] = useState(defaultState);

  const incrementCounter = (whichCounter) => {
    if (whichCounter === 1) {
      setCounter(counter => ({
        ...counter,
        counter1: counter.counter1+1
      }))
    } else {
      setCounter(counter => ({
        ...counter,
        counter2: counter.counter2+1
      }))
    }
  }


  return (
    <div className="App">
      <p>Counter clicked {counter.counter1} times</p>
      <button onClick={() => incrementCounter(1)}>click</button>

      <p>Counter clicked {counter.counter2} times</p>
      <button onClick={() => incrementCounter(2)}>click</button>

      <button onClick={() => {
        setCounter(defaultState)
      }}>clear state</button>
    </div>
  );
}

export default App;
*/
/*
import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

const App = () => {

  const defaultCurrentWord = "";

  const [words, setWords] = useState(["one", "two"]);
  const [currentWord, setCurrentWord] = useState(defaultCurrentWord);

  const addWord = () => {
    setWords(words => ([
      ...words,
      currentWord
    ]));

    setCurrentWord(defaultCurrentWord);
  }

  return (
    <div className="App">
      <input type="text" placeholder="enter text" value={currentWord} onChange={(e) => setCurrentWord(e.target.value)}/>
      <button onClick={() => addWord()}>Add</button>
      {
        words.map((el) => {
          return (
            <p>{el}</p>
          );
        })
      }
    </div>
  );
}

export default App;
*/

import logo from './logo.svg';
import './App.css';
import React  from 'react';
import Routes from './routes';
const App = () => {
  
  return(
    <Routes/>
  );
}
export default App;