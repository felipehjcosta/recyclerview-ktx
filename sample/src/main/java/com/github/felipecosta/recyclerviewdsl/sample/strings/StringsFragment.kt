package com.github.felipecosta.recyclerviewdsl.sample.strings

import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.felipecosta.recyclerviewdsl.R
import com.github.felipehjcosta.recyclerviewdsl.onRecyclerView


class StringsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recyclerview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val titles = listOf(
            "Spider-Man",
            "Thor",
            "Iron Man",
            "Black Panther",
            "Black Widow",
            "Captain America",
            "Captain Marvel",
            "Falcon",
            "Hank Pym",
            "Hawkeye",
            "Hulk"
        )

        onRecyclerView(recyclerView) {
            withLinearLayout {
                orientation = RecyclerView.VERTICAL
                reverseLayout = false
            }

            bind(R.layout.strings_list_item) {
                withItems(titles) {
                    on<TextView>(R.id.title) {
                        it.view?.text = it.item
                    }

                    onClick { position, string ->
                        Toast.makeText(
                            context,
                            "Position $position clicked for item: $string",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.recyclerview_options_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_linear_layout -> {
                changeToRecyclerViewToLinearLayout()
                true
            }
            R.id.action_grid_layout -> {
                changeToRecyclerViewToGridLayout()
                true
            }
            R.id.action_add_data -> {
                addExtraData()
                true
            }
            R.id.action_reset_data -> {
                resetData()
                true
            }
            R.id.action_change_data -> {
                changeData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun changeToRecyclerViewToLinearLayout() {
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)
        onRecyclerView(recyclerView) {
            withLinearLayout {
                orientation = RecyclerView.VERTICAL
                reverseLayout = false
            }
        }
    }

    private fun changeToRecyclerViewToGridLayout() {
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)
        onRecyclerView(recyclerView) {
            withGridLayout {
                orientation = RecyclerView.VERTICAL
                reverseLayout = false
                spanCount = 2
            }
        }
    }

    private fun addExtraData() {
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)
        onRecyclerView(recyclerView) {
            bind(R.layout.strings_list_item) {
                addExtraItems(listOf("New Hero here"))
            }
        }
    }

    private fun resetData() {
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)
        val titles = listOf(
            "Spider-Man",
            "Thor",
            "Iron Man",
            "Black Panther",
            "Black Widow",
            "Captain America",
            "Captain Marvel",
            "Falcon",
            "Hank Pym",
            "Hawkeye",
            "Hulk"
        )

        onRecyclerView(recyclerView) {
            bind(R.layout.strings_list_item) {
                withItems(titles) {
                    on<TextView>(R.id.title) {
                        it.view?.text = it.item
                    }

                    onClick { position, string ->
                        Toast.makeText(
                            context,
                            "Position $position clicked for item: ${string}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }
    }

    private fun changeData() {
        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recycler_view)
        val titles = listOf(
            "Black Panther",
            "Captain Marvel",
            "Hank Pym",
            "Spider-Man"
        )

        onRecyclerView(recyclerView) {
            bind(android.R.layout.simple_list_item_1) {
                withItems(titles) {
                    on<TextView>(android.R.id.text1) {
                        it.view?.text = it.item
                    }

                    onClick { position, string ->
                        Toast.makeText(
                            context,
                            "Position $position clicked for item: ${string}",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }
    }
}
