"use client";
import api from "./requests/request";
import { useEffect, useState } from "react";

import Typography from "@mui/material/Typography";

export const runtime = "edge";
export const preferredRegion = "home";

export default async function Home() {
  const [papel, setPapel] = useState();

  function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault();
    const form = event.currentTarget;
    const formElements = form.elements as typeof form.elements & {
      usernameInput: HTMLInputElement;
    };
    console.log(formElements.usernameInput.value);
  }

  useEffect(() => {
    api
      .get("/papeis/")
      .then((response: any) => setPapel(response.data))
      .catch((err: Error) => {
        console.error("ops! ocorreu um erro" + err);
      });
  }, []);
  return (
    <div>
      <Typography variant="h2">Papeis</Typography>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="yourInputName">Username:</label>
          <input id="yourInputName" type="text" />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
