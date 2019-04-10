import React, { Component } from 'react';
import './mainpage.css';
import { Navbar, NavItem, Nav } from 'react-bootstrap';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

class MainPage extends Component {
    render() {
        return (
            <Router>
        <div>
          <h2>Welcome to Edugate!</h2>
          <nav className="navbar navbar-expand-lg navbar-light bg-light">
          <ul className="navbar-nav mr-auto">
            <li><Link to={'/'} className="nav-link"> Kursy </Link></li>
            <li><Link to={'/'} className="nav-link">Zajęcia</Link></li>
            <li><Link to={'/'} className="nav-link">Ulubione</Link></li>
            <li><Link to={'/'} className="nav-link">Testy</Link></li>
            <li><Link to={'/'} className="nav-link">Profil</Link></li>
          </ul>
          </nav>
          <Switch>
          </Switch>
        </div>
      </Router>
        )
    }
}

export default MainPage;