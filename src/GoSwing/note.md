# Swing

The thing that makes Swing easy is the thing that makes it hard to control -- the Layout Manageerchanger. Layout Manager objects control the size and locaiton of the widgest in a Java GUI.

## Swing Components

Component is the more correct term for what we've been calling a widget. The things you put in a GUI. _The things a user sees and interacts with._ Text fields, buttons, scrollable lists, radio buttons, etc. are all components. In fact, they all extends javax.swing.JComponent.

**Components can be nested**
In Swing, virtually all components are capable of holding other components. In other words, you can _stick just about anything into anythign else_. But most of the time, you'll add _user interactive_ components such as buttons and lists into _background_ components such as frames and panels.

With the exception of JFrame, though, the distinction between interactive components and _background_ components is artificial. A JPanel, for example, is usually used as a backgro8und for grouping other components, but even JPanel can be interactive. Just as with other components, you can register for the JPanel's events including mouse clicks and keystrokes.

**Four steps to making a GUI**

1. Make a window (a JFrame)
   `JFrame frame = new JFrame();`

2. Make a component(button, text field, etc)
   `JButton button = new JButton("click me");`

3. Add the component to the frame
   `frame.getContentPane().add(BorderLayout.EAST, button)`

4. Display it (give it a sive and make it visible)
   `frame.setSize(300, 300);`
   `frame.setVisible(true);`

## Layout Managers

Different layout managers have different policies for arranging components (like, arrange in a grid, make htem all the same size, stack them vertically, etc.) but the components being layed out do get at least some small say in the matter.

**A layout scenario:**

1. Make a panel and add three buttons to it
2. The panel's layout manager asks each button how bit that button preferes to be.
3. The panel's layout manager uses its layout policies to decide whether it should respect all, part, or none of the button's preferences.
4. Add the panel to the frame.
5. The frame's layout manager asks the panel how bit the panel prefers to be.
6. The frame's layout manager uses its layout policies to decide whether it should respect all, part or none of the panel's preferences.

### Border Layout

![](https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/doc-files/BorderLayout-1.gif)

Compoents laid out by this manager usually don't get to have their preferred size. BorderLayout is the default layout manager for a frame.

### Flow Layout

![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/FlowLayoutDemo1.png)

Each componets is the size it wants to be, and they're laid out left to right in the order that they're added, with "word-wrap" turned on. So when a component won't fit horizontally, it drops to the next "line" in the layout. FlowLayout is the default layout manager for a panel .

### Box Layout

![](https://docs.oracle.com/javase/tutorial/figures/uiswing/layout/BoxLayoutDemo.png)

A BoxLayout manager is like FlawLayout in that each component gets to have its own size, and the components are placed in the order in which they're added. But, unlike FlowLayout, a BoxLayout manager can stack the components vertically (or horizontally, but usually we're just concerned with vertically). It's like a FlowLayout but instead of having automatic 'component wrapping', you can insert a sort of 'component return key' and force the component to start a new line.
