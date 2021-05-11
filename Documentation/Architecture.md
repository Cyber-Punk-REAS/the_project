# My General Architecture
## Component-based development *(CBD)*
### What?
Architecture based on dividing the SUD in modules that then will be interconnected by the use of interfaces. The modules are an arbitrary section of the SUD that is independent where all its parts are sematically related. This makes the code *modular* and *cohesive*. When a component offers services to another,  it adopts a *provided* interface that specifies the services that other components can utilize, and how they can do so. In this way the other component doesn't need to know how the one works. Thus making the components *encapsulated*.
### Why?
From the developer point of view I think this could be the most efficient way to develop the SUD. Because the workload can be more easily divided.
And because we can find this components inherent to our project. For example the Region with its Areas, Population, and Restrictions; the Simulation; the ResultComparer with Result (or Simulation with Result, it can be either way)...
Also, because this Architectural Style can be host to other Architectural Styles used within the components.
# My Proposal
We could use the *CBD* as the higher abstraction Architectural style and then others for the implementation of the components.
For example:
- For Simulation -> Event-driven architecture
- For components -> that require UI PAC
- For ResultComparer -> Rules Based Style
