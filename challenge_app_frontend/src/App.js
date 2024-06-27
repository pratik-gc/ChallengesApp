import logo from './logo.svg';
import './App.css';
import ChallengeList from './components/ChallengeList';
import { useEffect, useState } from 'react';
import axios from 'axios';
import AddChallenge from './components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {

  // useState hook is used to manage the state of our components based on the interaction
  const [challenges, setChallenges] = useState([]);


  // useEffect hook is used to communicate/interact with outside world (Backend APIs) i.e. get the data from SpringBoot App and so on.
  useEffect( () => {
    fetchChallenges();
  }, [] );

  const fetchChallenges = async () => {
    try {
    //code to fetch the data
    //axios is used to make API call. axios is a popular JavaScript Library for  making HTTP requests from JavaScript code.
    const response = await axios.get('http://localhost:8080/challenges');
    //console.log(response.data);
    setChallenges(response.data);

    } catch (error) {
      console.error("Error in fetching challenges : ", error);
    }

  };

  const handleChallengeAdded = () => {
      fetchChallenges();
  }

  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challenges</h1>
      <AddChallenge onChallengeAdded = {handleChallengeAdded} />
      <ChallengeList challenges = {challenges}/>
      
    </div>
  );
}

export default App;
