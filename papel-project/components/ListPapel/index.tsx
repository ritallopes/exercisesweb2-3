import * as React from "react";
import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import styled from "@emotion/styled";

const MyTableRow = styled(TableRow)(() => ({
  "&:nth-of-type(odd)": {
    backgroundColor: "#91D8D8",
  },
  // hide last border
  "&:last-child td, &:last-child th": {
    border: 0,
  },
}));
interface IPapel {
  nome: string;
  descricao: string;
}
export default function ListPapel() {
  const papeis = React.useState<IPapel[]>();
  return (
    <>
      <Typography variant="h1" component="h2">
        Papel
      </Typography>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 700 }} aria-label="customized table">
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell align="right">Descrição</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {papeis.length &&
              papeis.map((value) => (
                <MyTableRow key={`key=${value.nome}`}>
                  <TableCell component="th" scope="row">
                    {value?.nome}
                  </TableCell>
                  <TableCell align="right">{value?.descricao}</TableCell>
                </MyTableRow>
              ))}
          </TableBody>
        </Table>
      </TableContainer>
      );
    </>
  );
}
