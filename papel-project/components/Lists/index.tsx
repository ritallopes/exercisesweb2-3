import * as React from "react";
import Box from "@mui/material/Box";

import { Tab, Tabs, Typography } from "@mui/material";

import ListPapel from "./ListPapel";

interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

function a11yProps(index: number) {
  return {
    id: `simple-tab-${index}`,
    "aria-controls": `simple-tabpanel-${index}`,
  };
}
function TabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}
export default function Lists() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
  };
  return (
    <>
      <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label="Tabs do projeto Papel"
        >
          <Tab label="Papéis" {...a11yProps(0)} />
          <Tab label="Usuários" {...a11yProps(1)} />
          <Tab label="Pessoas" {...a11yProps(2)} />
        </Tabs>
      </Box>
      <TabPanel value={value} index={0}>
        <ListPapel />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <ListPapel />
      </TabPanel>
      <TabPanel value={value} index={2}>
        <ListPapel />
      </TabPanel>
    </>
  );
}
