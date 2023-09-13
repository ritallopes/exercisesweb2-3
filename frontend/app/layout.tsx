export const metadata = {
  title: "Consume API Papeis",
  description: "Projeto para consumir api do projeto Papeis",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
