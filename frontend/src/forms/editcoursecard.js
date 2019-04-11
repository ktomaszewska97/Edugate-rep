import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import Alert from 'react-s-alert';

class EditCard extends Component {
    constructor(props) {
        super(props);
        console.log(props);
    }
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Informacje o kursie</h1>
                    {/*<p>{this.props.currentUser.name}</p>*/}
                    <EditCardForm {...this.props} />
                </div>
            </div>
        );
    }
}

class EditCardForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            fieldOfStudy: '',
            semester: '',
            level: '',
            name: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;

        const inputFieldOfStudy = target.fieldOfStudy;        
        const inputSemester = target.semester;
        const inputLevel = target.level;        
        const inputName = target.name;

        this.setState({
            [inputFieldOfStudy] : inputFieldOfStudy,
            [inputSemester] : inputSemester,
            [inputLevel] : inputLevel,
            [inputName] : inputName
        });        
    }

    handleSubmit(event) {
        event.preventDefault();   
        const signUpRequest = Object.assign({}, this.state);
        {/*}
        signup(signUpRequest)
        .then(response => {
            Alert.success("You're successfully registered. Now you can use Edugate!");
            this.props.history.push("/login");
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });
    */}
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="form-item">
                    <input type="text" name="fieldOfStudy" 
                        className="form-control" placeholder="Field of study" 
                        fieldOfStudy={this.state.fieldOfStudy} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="number" name="" 
                        className="form-control" placeholder="Semester"
                        semester={this.state.semester} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="number" name="Level" 
                        className="form-control" placeholder="Level"
                        level={this.state.level} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <input type="text" name="Name" 
                        className="form-control" placeholder="Name" maxLength="50"
                        name={this.state.name} onChange={this.handleInputChange} required/>
                </div>
                <div className="form-item">
                    <a href="/editcoursecarddesc" className="btn btn-block btn-primary">Dalej</a>
                </div>
            </form>                    

        );
    }
}
{/*Dopisać przesyłanie do bazy, wraz z kliknięciem DALEJ*/}
export default EditCard;