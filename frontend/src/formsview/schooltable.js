import React, { Component } from 'react';
import { getSchools } from '../util/APIUtils';

class SchoolTable extends Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            schools: []
        };
    }

    loadSchools() {
      getSchools()
      .then(response => {
        this.setState({
          schools: response,
        });
      }).catch(error => {
        this.setState({
          schools: null
        });  
      });    
      console.log("Sprawdzam!")
    }

    componentDidMount() {
      this.loadSchools();
    }
  

    render() {
    return (
      <div>
      <p>{this.props.currentUser.name}</p>
      <table class="table table-striped">
        <thead>
          <tr>
            <th>Id</th><th>Nazwa</th><th>O uczelni</th><th>Opis</th>
          </tr>
        </thead>
        <tbody>
                {this.state.schools.map(school =>
                  <tr>
                    <td>{school.idschool}</td>
                    <td>{school.name}</td>
                    <td>{school.about}</td>
                    <td>{school.description}</td>
                  </tr>
                )}
              </tbody>
      </table>
      </div>
      );
  }
}

export default SchoolTable;

