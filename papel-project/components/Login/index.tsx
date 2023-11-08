import React, { Dispatch, SetStateAction, useState } from "react";
import { useNavigate } from "react-router-dom";

interface LoginProps {
  setLoggedIn: Dispatch<SetStateAction<boolean>>;
}
const Login = ({ setLoggedIn }: LoginProps) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");

  const navigate = useNavigate();

  const onButtonClick = () => {
    // You'll update this function later...
  };

  return (
    <div className={"mainContainer"}>
      <div className={"titleContainer"}>
        <div>Login</div>
      </div>
      <br />
      <div className={"inputLoginCtn"}>
        <input
          value={email}
          placeholder="Enter your email here"
          onChange={(ev) => setEmail(ev.target.value)}
          className={"inputLogin"}
        />
        <label className="errorLabel">{emailError}</label>
      </div>
      <br />
      <div className={"inputLoginCtn"}>
        <input
          value={password}
          placeholder="Enter your password here"
          onChange={(ev) => setPassword(ev.target.value)}
          className={"inputLogin"}
        />
        <label className="errorLabel">{passwordError}</label>
      </div>
      <br />
      <div className={"inputLoginCtn"}>
        <input
          className={"inputButton"}
          type="button"
          onClick={onButtonClick}
          value={"Log in"}
        />
      </div>
    </div>
  );
};

export default Login;
